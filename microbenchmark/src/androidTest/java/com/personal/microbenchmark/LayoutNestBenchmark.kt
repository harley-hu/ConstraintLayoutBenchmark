package com.personal.microbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Alphanumeric

/**
 * 测量 linearlayout、relativeLayout嵌套深度影响
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class LayoutNestBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun linearLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.layout_nest_linearlayout
        )
    }

    @Test
    fun relativeLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.layout_nest_relativelayout
        )
    }
}