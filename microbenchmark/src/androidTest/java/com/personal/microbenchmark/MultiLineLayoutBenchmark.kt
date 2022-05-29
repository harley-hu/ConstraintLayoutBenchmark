package com.personal.microbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * 多行View展示，用于验证布局排列对于性能影响
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MultiLineLayoutBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun linearLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_linearlayout_at_most
        )
    }

    @Test
    fun linearLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_linearlayout_exactly
        )
    }

    @Test
    fun relativeLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_relative_layout_at_most
        )
    }

    @Test
    fun relativeLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_relativelayout_exactly
        )
    }

    @Test
    fun constraintLayout_at_most_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_constraintlayout_at_most
        )
    }

    @Test
    fun constraintLayout_exactly_measure() {
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.multi_line_constraintlayout_exactly
        )
    }
}