package com.s2tek.linkedlist

class LinkedListIterable<T> : LinkedList<T>(), Iterable<T> {
  override fun iterator(): Iterator<T> {
    return LinkedListIterator(head)
  }
}
