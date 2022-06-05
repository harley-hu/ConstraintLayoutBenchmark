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
 * ConstraintLayout group inflate耗时测试
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class ConstraintLayoutGroupBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun constraintLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutInflate(
            benchmarkRule,
            R.layout.multi_line_constraintlayout_group
        )
    }
}