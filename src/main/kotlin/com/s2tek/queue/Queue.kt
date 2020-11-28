package com.s2tek.queue

import com.s2tek.linkedlist.Node

class Queue<T> : IQueue<T> {
  private var head: Node<T>? = null
  private var tail: Node<T>? = null

  override fun enqueue(value: T) {
    val node = Node(value)

    if (head == null) {
      head = node
      tail = node
    } else {
      tail!!.next = node
      tail = node
    }
  }

  override fun dequeue(): T? {
    return if (head != null) {
      val value = head!!.value
      head = head!!.next

      value
    } else {
      null
    }
  }

  override fun toString(): String {
    return if (head != null) {
      "$head"
    } else {
      "Queue is empty."
    }
  }
}
