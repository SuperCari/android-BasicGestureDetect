package com.example.android.common.logger


class MessageOnlyLogFilter extends LogNode {
  private[logger] var mNext: LogNode = null

  /**
    * Takes the "next" LogNode as a parameter, to simplify chaining.
    *
    * @param next The next LogNode in the pipeline.
    */
  def this(next: LogNode) {
    this()
    mNext = next
  }

  def println(priority: Int, tag: String, msg: String, tr: Throwable) {
    if (mNext != null) {
      getNext.println(Log.NONE, null, msg, null)
    }
  }

  /**
    * Returns the next LogNode in the chain.
    */
  def getNext: LogNode = mNext

  /**
    * Sets the LogNode data will be sent to..
    */
  def setNext(node: LogNode) {
    mNext = node
  }
}