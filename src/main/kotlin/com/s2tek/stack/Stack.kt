package com.s2tek.stack

import com.s2tek.linkedlist.LinkedList

class Stack<T> : IStack<T> {
  private val list = LinkedList<T>()

  override fun pop(): T? {
    val value = list.at(0)

    if (value != null) {
      list.remove(0)
    }

    return value
  }

  override fun push(value: T) {
    list.insert(value, 0)
  }
}
