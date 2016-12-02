package com.example.android.common.logger

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView

class LogFragment extends Fragment {
  private var mLogView: LogView = null
  private var mScrollView: ScrollView = null

  def inflateViews: View = {
    mScrollView = new ScrollView(getActivity)
    val scrollParams: ViewGroup.LayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    mScrollView.setLayoutParams(scrollParams)
    mLogView = new LogView(getActivity)
    val logParams: ViewGroup.LayoutParams = new ViewGroup.LayoutParams(scrollParams)
    logParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    mLogView.setLayoutParams(logParams)
    mLogView.setClickable(true)
    mLogView.setFocusable(true)
    mLogView.setTypeface(Typeface.MONOSPACE)
    val paddingDips: Int = 16
    val scale: Double = getResources.getDisplayMetrics.density
    val paddingPixels: Int = ((paddingDips * (scale)) + .5).toInt
    mLogView.setPadding(paddingPixels, paddingPixels, paddingPixels, paddingPixels)
    mLogView.setCompoundDrawablePadding(paddingPixels)
    mLogView.setGravity(Gravity.BOTTOM)
    mLogView.setTextAppearance(android.R.style.TextAppearance_Holo_Medium)
    mScrollView.addView(mLogView)
    mScrollView
  }

  override def onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle): View = {
    val result: View = inflateViews
    mLogView.addTextChangedListener(new TextWatcher() {
      def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
      }

      def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
      }

      def afterTextChanged(s: Editable) {
        mScrollView.fullScroll(View.FOCUS_DOWN)
      }
    })
    result
  }

  def getLogView: LogView = {
    mLogView
  }
}