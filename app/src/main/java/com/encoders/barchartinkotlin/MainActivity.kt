package com.encoders.barchartinkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class MainActivity : AppCompatActivity() {
    var valueList = ArrayList<Double>()
    var entries: ArrayList<BarEntry> = ArrayList()
    var title = "Title"
    private lateinit var barChart: BarChart
    var times: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        barChart = findViewById(R.id.barChart)


        RoundedBarChartRenderer(barChart, barChart.animator, barChart.viewPortHandler, 25f)

        showbarChart()
    }


    fun showbarChart() {

        times = arrayListOf()
        valueList = arrayListOf()


        times.add("1 AM")
        times.add("2 AM")
        times.add("3 AM")
        times.add("4 AM")
        times.add("5 AM")
        times.add("6 AM")
        times.add("7 AM")
        times.add("8 AM")
        times.add("9 AM")
        times.add("10 AM")
        times.add("11 AM")

        valueList.add(10.0)
        valueList.add(20.0)
        valueList.add(30.0)
        valueList.add(40.0)
        valueList.add(50.0)
        valueList.add(60.0)
        valueList.add(70.0)
        valueList.add(80.0)
        valueList.add(90.0)
        valueList.add(100.0)
        valueList.add(110.0)


        barchartCustomization()

    }


    fun barchartCustomization() {

        for (i in valueList.indices) {
            val barEntry = BarEntry(i.toFloat(), valueList[i].toFloat())
            entries.add(barEntry)
        }

        val barDataSet = BarDataSet(entries, title)

        val data = BarData(barDataSet)
        barChart.data = data
        barChart.invalidate()
        barChart.animateXY(2000, 2000)

        barDataSet.color = resources.getColor(R.color.purple_200)
        barDataSet.setDrawValues(false)

        barChart.data = BarData(barDataSet).apply {
            barWidth = 0.15f
        }


//        barChart.renderer =
//            RoundedBarChartRenderer(barChart, barChart.animator, barChart.viewPortHandler, 25f)


        barChart.xAxis.setDrawGridLines(false)
        barChart.axisRight.setDrawGridLines(false)
        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisRight.setDrawAxisLine(false)
        barChart.axisLeft.setDrawAxisLine(false)
        barChart.axisLeft.setDrawLabels(false)
        barChart.axisRight.setDrawLabels(false)
        barChart.xAxis.setDrawAxisLine(false)
        barChart.legend.isEnabled = false
        barChart.xAxis.labelRotationAngle = -45f
        barChart.xAxis.mLabelRotatedHeight = 100
        barChart.description.isEnabled = false

        barChart.animateXY(2000, 2000)

        val xAxis: XAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(times)
        barChart.xAxis.labelCount = 11

        barChart.axisLeft.axisMinimum = 0f

    }

}