package com.s2tek.queue

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class QueueTest {
  private val queue = Queue<Int>()

  @Test
  fun enqueueOneTime() {
    queue.enqueue(1)
    val expect = "1"

    assertEquals(expect, "$queue")
  }

  @Test
  fun enqueueMoreTimes() {
    queue.enqueue(3)
    queue.enqueue(2)
    queue.enqueue(1)
    val expect = "3 -> 2 -> 1"

    assertEquals(expect, "$queue")
  }

  @Test
  fun dequeueAnEmptyQueue() {
    val value = queue.dequeue()

    assertNull(value)
    assertEquals("Queue is empty.", "$queue")
  }

  @Test
  fun dequeueTheQueueHasOneElement() {
    queue.enqueue(1)
    val actual = queue.dequeue()

    assertEquals(1, actual)
  }
}
