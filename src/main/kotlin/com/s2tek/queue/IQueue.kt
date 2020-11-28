package com.s2tek.queue

interface IQueue<T> {
  fun enqueue(value: T)
  fun dequeue(): T?
}
