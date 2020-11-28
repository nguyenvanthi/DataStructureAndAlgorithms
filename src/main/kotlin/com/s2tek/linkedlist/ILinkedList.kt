package com.s2tek.linkedlist

interface ILinkedList<T> {
  fun insert(value: T, index: Int)
  fun at(index: Int): T?
  fun remove(index: Int)
}
