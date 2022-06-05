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
 * LinearLayout、relativeLayout、frameLayout、constraintLayout inflate 耗时统计
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class LayoutInflateBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun linearLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutInflate(
            benchmarkRule,
            R.layout.linearlayout_inflate_time
        )
    }

    @Test
    fun frameLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutInflate(
            benchmarkRule,
            R.layout.framelayout_inflate_time
        )
    }

    @Test
    fun relativeLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutInflate(
            benchmarkRule,
            R.layout.relativelayout_inflate_time
        )
    }

    @Test
    fun constraintLayoutTest(){
        LayoutPerformanceUtils.analysisLayoutInflate(
            benchmarkRule,
            R.layout.constraintlayout_inflate_time
        )
    }

}