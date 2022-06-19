package com.personal.microbenchmark

import android.view.View
import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Alphanumeric

/**
 * 单行不同布局实现，验证简单布局效果和每个TextView添加耗时
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class SingleLineLayoutBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()


    @Test
    fun linearLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_linearlayout_at_most,
            View.MeasureSpec.AT_MOST
        )
    }

    @Test
    fun linearLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_linearlayout_exactly
        )
    }

    @Test
    fun relativeLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_relativelayout_at_most,
            View.MeasureSpec.AT_MOST
        )
    }

    @Test
    fun relativeLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_relativelayout_exactly
        )
    }

    @Test
    fun constraintLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_constraintlayout_at_most,
            View.MeasureSpec.AT_MOST
        )
    }

    @Test
    fun constraintLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_constraintlayout_exactly
        )
    }


}