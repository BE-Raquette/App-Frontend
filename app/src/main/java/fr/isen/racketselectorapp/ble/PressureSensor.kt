package fr.isen.racketselectorapp.ble

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.bluetooth.*
import android.bluetooth.BluetoothProfile.GATT
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import java.util.*

@SuppressLint("MissingPermission")
class PressureSensor (private val context: Context) {

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()


    private val bluetoothGattCallback = object : BluetoothGattCallback() {

        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                gatt.discoverServices()
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            val service = gatt.getService(PRESSURE_SENSOR_SERVICE_UUID)
            val characteristic = service.getCharacteristic(PRESSURE_SENSOR_CHARACTERISTIC_UUID)
            gatt.setCharacteristicNotification(characteristic, true)
            val desc = characteristic.getDescriptor(PRESSURE_SENSOR_CHARACTERISTIC_UUID)
            desc.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)
            gatt.writeDescriptor(desc)
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            val pressure = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 0)
            Log.d(TAG, "Pressure value received: $pressure")

            // Utiliser la valeur de pression récupérée ici
        }
    }

    fun connectToSensor(sensorAddress: String){
        val device = bluetoothAdapter?.getRemoteDevice(sensorAddress)
        //TODO chercher le GATT SANS AVOIR BESOIN DE LA MAC ADRESSE
        val gatt = device?.connectGatt(context, false, bluetoothGattCallback)
        if (gatt != null) {
            this.bluetoothGattCallback.onServicesDiscovered(gatt, 1)
        }
    }

    companion object {
        val PRESSURE_SENSOR_SERVICE_UUID = UUID.fromString("00001801-0000-1000-8000-00805f9b34fb")
        val PRESSURE_SENSOR_CHARACTERISTIC_UUID = UUID.fromString("00002A6D-0000-1000-8000-00805f9b34fb")
    }


}