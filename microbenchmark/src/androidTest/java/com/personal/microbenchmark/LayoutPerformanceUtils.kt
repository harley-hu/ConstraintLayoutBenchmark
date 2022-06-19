package com.personal.microbenchmark

import android.view.LayoutInflater
import android.view.View
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.platform.app.InstrumentationRegistry

object LayoutPerformanceUtils {

    /**
     * 统计分析布局文件加载耗时
     */
    fun analysisLayoutInflate(benchmarkRule: BenchmarkRule, layoutResId: Int) {
        val context = InstrumentationRegistry.getInstrumentation().context
        val inflater = LayoutInflater.from(context)

        benchmarkRule.measureRepeated {
            inflater.inflate(layoutResId, null)
        }
    }

    /**
     * 统计分析布局文件 measure + layout 耗时，原因：
     * 1. 相对于 inflate 而言，measure 和 layout 一般会被同时调用
     * 2. measure 和 layout 对于一些 View 而言，职责并没有特别限定，因此从一些系统代码中可以发现，measure 和 layout存在相互调用的情况
     */
    fun analysisLayoutMeasureAndLayout(
        benchmarkRule: BenchmarkRule,
        layoutResId: Int,
        mode: Int = View.MeasureSpec.EXACTLY
    ) {
        val context = InstrumentationRegistry.getInstrumentation().context
        val inflater = LayoutInflater.from(context)

        benchmarkRule.measureRepeated {
            // Not to use the view cache in the View class, we inflate it every time
            val container = runWithTimingDisabled {
                inflater.inflate(layoutResId, null)
            }
            val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(1080, mode)
            val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(1920, mode)

            container.measure(widthMeasureSpec, heightMeasureSpec)
            container.layout(0, 0, container.measuredWidth, container.measuredHeight)
        }
    }

    fun analysisViewMeasureAndLayout(
        benchmarkRule: BenchmarkRule,
        view: View,
        mode: Int = View.MeasureSpec.EXACTLY
    ) {
        benchmarkRule.measureRepeated {
            val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(1080, mode)
            val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(1920, mode)

            view.measure(widthMeasureSpec, heightMeasureSpec)
            view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        }
    }

}