package com.s2tek.linkedlist

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LinkedListIteratorTest {
  @Test
  fun hasNextWhileNodeIsNull() {
    val iterator = LinkedListIterator<Int>(null)

    assertFalse(iterator.hasNext())
  }

  @Test
  fun hasNextWhileNodeIsNotNull() {
    val iterator = LinkedListIterator(Node(1))

    assertTrue(iterator.hasNext())
  }

  @Test
  fun nextWhileNodeIsNull() {
    val iterator = LinkedListIterator<Int>(null)

    assertFails {
      iterator.next()
    }
  }

  @Test
  fun nextWhileNodeIsNotNull() {
    val iterator = LinkedListIterator(Node(1))

    assertEquals(1, iterator.next())
  }

  @Test
  fun nextWhileNodeHasNextValue() {
    val iterator = LinkedListIterator(Node(1, Node(2)))

    assertEquals(1, iterator.next())
  }
}
