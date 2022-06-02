package com.personal.microbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Alphanumeric

@LargeTest
@RunWith(AndroidJUnit4::class)
@OrderWith(Alphanumeric::class)
class SingleLineLayoutWeightBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun constraintLayout_measure(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_weight_constraintlayout
        )
    }

    @Test
    fun linearLayout_measure(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_weight_linearlayout
        )
    }

    @Test
    fun constraint_linearLayout_measure(){
        LayoutPerformanceUtils.analysisLayoutMeasureAndLayout(
            benchmarkRule,
            R.layout.single_line_weight_constraint_linearlayout
        )
    }
}