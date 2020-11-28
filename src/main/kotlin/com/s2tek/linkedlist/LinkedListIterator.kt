package com.s2tek.linkedlist

class LinkedListIterator<T>(private var node: Node<T>?) : Iterator<T> {
  override fun hasNext(): Boolean {
    return node != null
  }

  override fun next(): T {
    val value = node!!.value

    node = node!!.next

    return value
  }
}
