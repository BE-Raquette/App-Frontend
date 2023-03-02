package fr.isen.racketselectorapp.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.databinding.ActivityStatisticsBinding

class StatisticsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatisticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prehensionFirstLine = setLineChartData(prehensionFirstLine(), R.color.teal_light)
        val prehensionSecondLine = setLineChartData(prehensionSecondLine(), R.color.teal_dark)

        val speedFirstLine = setLineChartData(speedFirstLine(), R.color.teal_light)
        val speedSecondLine = setLineChartData(speedSecondLine(), R.color.teal_dark)

        val prehensionLines = listOf<LineDataSet>(prehensionFirstLine, prehensionSecondLine)
        val speedLines = listOf<LineDataSet>(speedFirstLine, speedSecondLine)

        drawChart(prehensionLines, binding.prehensionGraph)
        drawChart(speedLines, binding.speedGraph)
    }

    private fun prehensionFirstLine(): ArrayList<Entry> {
        val lineValues = ArrayList<Entry>()
        lineValues.add(Entry(0f, 5.1F))
        lineValues.add(Entry(5f, 5.3F))
        lineValues.add(Entry(10f, 5.2F))
        lineValues.add(Entry(15f, 5.5F))
        lineValues.add(Entry(20f, 5.3F))
        lineValues.add(Entry(25f, 5.7F))
        lineValues.add(Entry(30f, 7.3F))
        lineValues.add(Entry(35f, 9.1F))
        lineValues.add(Entry(40f, 15.2F))
        lineValues.add(Entry(45f, 17.8F))
        lineValues.add(Entry(50f, 19.5F))
        lineValues.add(Entry(55f, 18.6F))
        lineValues.add(Entry(60f, 17.1F))
        lineValues.add(Entry(65f, 10.0F))
        lineValues.add(Entry(70f, 7.7F))
        lineValues.add(Entry(75f, 6.5F))
        lineValues.add(Entry(80f, 5.6F))
        lineValues.add(Entry(85f, 5.2F))
        lineValues.add(Entry(90f, 5.0F))
        lineValues.add(Entry(95f, 4.8F))
        lineValues.add(Entry(100f, 5.0F))
        return lineValues
    }

    private fun prehensionSecondLine(): ArrayList<Entry> {
        val lineValues = ArrayList<Entry>()
        lineValues.add(Entry(0f, 4.1F))
        lineValues.add(Entry(5f, 4.6F))
        lineValues.add(Entry(10f, 4.3F))
        lineValues.add(Entry(15f, 5.0F))
        lineValues.add(Entry(20f, 5.3F))
        lineValues.add(Entry(25f, 5.5F))
        lineValues.add(Entry(30f, 7.0F))
        lineValues.add(Entry(35f, 8.7F))
        lineValues.add(Entry(40f, 13.2F))
        lineValues.add(Entry(45f, 15.8F))
        lineValues.add(Entry(50f, 16.4F))
        lineValues.add(Entry(55f, 15.2F))
        lineValues.add(Entry(60f, 13.1F))
        lineValues.add(Entry(65f, 9.2F))
        lineValues.add(Entry(70f, 6.3F))
        lineValues.add(Entry(75f, 5.2F))
        lineValues.add(Entry(80f, 4.8F))
        lineValues.add(Entry(85f, 4.6F))
        lineValues.add(Entry(90f, 4.3F))
        lineValues.add(Entry(95f, 4.5F))
        lineValues.add(Entry(100f, 4.7F))
        return lineValues
    }

    private fun speedFirstLine(): ArrayList<Entry> {
        val lineValues = ArrayList<Entry>()
        lineValues.add(Entry(0f, 13f))
        lineValues.add(Entry(5f, 15f))
        lineValues.add(Entry(10f, 18f))
        lineValues.add(Entry(15f, 22f))
        lineValues.add(Entry(20f, 21f))
        lineValues.add(Entry(25f, 24f))
        lineValues.add(Entry(30f, 29f))
        lineValues.add(Entry(35f, 38f))
        lineValues.add(Entry(40f, 54f))
        lineValues.add(Entry(45f, 87f))
        lineValues.add(Entry(50f, 92f))
        lineValues.add(Entry(55f, 85f))
        lineValues.add(Entry(60f, 69f))
        lineValues.add(Entry(65f, 52f))
        lineValues.add(Entry(70f, 41f))
        lineValues.add(Entry(75f, 26f))
        lineValues.add(Entry(80f, 20f))
        lineValues.add(Entry(85f, 17f))
        lineValues.add(Entry(90f, 13f))
        lineValues.add(Entry(95f, 16f))
        lineValues.add(Entry(100f, 10f))
        return lineValues
    }

    private fun speedSecondLine(): ArrayList<Entry> {
        val lineValues = ArrayList<Entry>()
        lineValues.add(Entry(0f, 10f))
        lineValues.add(Entry(5f, 12f))
        lineValues.add(Entry(10f, 15f))
        lineValues.add(Entry(15f, 16f))
        lineValues.add(Entry(20f, 14f))
        lineValues.add(Entry(25f, 17f))
        lineValues.add(Entry(30f, 21f))
        lineValues.add(Entry(35f, 28f))
        lineValues.add(Entry(40f, 46f))
        lineValues.add(Entry(45f, 76f))
        lineValues.add(Entry(50f, 84f))
        lineValues.add(Entry(55f, 79f))
        lineValues.add(Entry(60f, 62f))
        lineValues.add(Entry(65f, 47f))
        lineValues.add(Entry(70f, 29f))
        lineValues.add(Entry(75f, 21f))
        lineValues.add(Entry(80f, 16f))
        lineValues.add(Entry(85f, 15f))
        lineValues.add(Entry(90f, 11f))
        lineValues.add(Entry(95f, 13f))
        lineValues.add(Entry(100f, 12f))
        return lineValues
    }

    private fun setLineChartData(lineValues: ArrayList<Entry>, color: Int): LineDataSet {
        val lineDataset = LineDataSet(lineValues, "Préhension")
        //We add features to our chart
        lineDataset.color = resources.getColor(color)
        lineDataset.lineWidth = 3f
        lineDataset.circleRadius = 2f
        lineDataset.setCircleColors(color)
        lineDataset.valueTextSize = 0f
        lineDataset.mode = LineDataSet.Mode.CUBIC_BEZIER

        return lineDataset
    }

    private fun drawChart(linesDataSet: List<LineDataSet>, chart: LineChart) {
        val data = LineData(linesDataSet)
        chart.data = data
        chart.animateXY(2000, 2000, Easing.EaseInCubic)

        chart.description.isEnabled = false
        chart.legend.isEnabled = false

        chart.setTouchEnabled(false)
        chart.setPinchZoom(false)
        chart.setDrawGridBackground(false)

        val x: XAxis = chart.xAxis
        x.position = XAxis.XAxisPosition.BOTTOM
        x.setDrawAxisLine(true)
        x.setDrawGridLines(false)
        x.textColor = getColor(R.color.changing_theme)
        x.axisLineColor = getColor(R.color.changing_theme)

        val y: YAxis = chart.axisLeft
        y.setDrawZeroLine(true)
        y.setDrawGridLines(false)
        y.textColor = getColor(R.color.changing_theme)
        y.axisLineColor = getColor(R.color.changing_theme)

        chart.axisRight.isEnabled = false
    }
}