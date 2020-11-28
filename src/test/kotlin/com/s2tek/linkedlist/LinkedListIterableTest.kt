package com.s2tek.linkedlist

import org.junit.Test
import kotlin.test.assertNotNull

class LinkedListIterableTest {
  @Test
  fun iterator() {
    val iterable = LinkedListIterable<Int>()
    val actual = iterable.iterator()

    assertNotNull(actual)
  }
}
