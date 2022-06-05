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
 * 测试ConstraintLayout Barrier测量性能
 *
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class BarrierBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun constraintLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.barrier_for_constraintlayout
        )
    }

    @Test
    fun linearLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.barrier_for_linearlayout
        )
    }
}