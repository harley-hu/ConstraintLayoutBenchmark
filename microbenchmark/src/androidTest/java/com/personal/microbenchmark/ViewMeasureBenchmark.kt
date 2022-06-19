package com.personal.microbenchmark

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Alphanumeric

@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class ViewMeasureBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    /**
     * TextView宽高自适应时，测量其布局耗时
     */
    @Test
    fun measureTextView() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val view = TextView(context).apply {
            text = "TextView"
        }
        LayoutPerformanceUtils.analysisViewMeasureAndLayout(
            benchmarkRule,
            view,
            View.MeasureSpec.AT_MOST
        )
    }

    /**
     * ImageView固定宽高时，测量其布局耗时
     */
    @Test
    fun measureImageView() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val view = ImageView(context).apply {
            layoutParams = ViewGroup.LayoutParams(50,50)
        }
        LayoutPerformanceUtils.analysisViewMeasureAndLayout(
            benchmarkRule,
            view,
            View.MeasureSpec.EXACTLY
        )
    }

}