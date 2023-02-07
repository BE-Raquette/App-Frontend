package fr.isen.racketselectorapp.ble

import android.annotation.SuppressLint
import android.bluetooth.*
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import fr.isen.racketselectorapp.FormActivity
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.databinding.ActivityDeviceDetailBinding
import java.util.*

@SuppressLint("MissingPermission")
class DeviceDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeviceDetailBinding
    private var bluetoothGatt: BluetoothGatt? = null
    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeviceDetailBinding.inflate(layoutInflater)
        setContentView((binding.root))

        val device = intent.getParcelableExtra<BluetoothDevice?>(BleScanActivity.DEVICE_KEY)
        Toast.makeText(this, R.string.ble_device_connected, Toast.LENGTH_SHORT).show()

        connectToDevice(device)
    }

    //A enlever si on ne deconnecte pas du Ble à la fin
    override fun onStop() {
        super.onStop()
      // closeBluetoothGatt()
    }

    private fun closeBluetoothGatt() {
        bluetoothGatt?.close()
        bluetoothGatt = null
    }


    private fun connectToDevice(device: BluetoothDevice?) {
        this.bluetoothGatt = device?.connectGatt(this, true, gattCallback)
        this.bluetoothGatt?.connect()
    }

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            super.onConnectionStateChange(gatt, status, newState)
            when (newState) {
                BluetoothGatt.STATE_CONNECTED -> {
                    gatt?.discoverServices()
                    runOnUiThread {

                        goToFormActivity()
                    }
                }
                BluetoothGatt.STATE_CONNECTING -> {

                }
                else -> {

                }
            }
        }
    }

    private fun goToFormActivity() {
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
        finish()
    }
}