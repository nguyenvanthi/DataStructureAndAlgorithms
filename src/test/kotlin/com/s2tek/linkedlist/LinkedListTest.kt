package com.s2tek.linkedlist

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNull

class LinkedListTest {
  private var linkedList = LinkedList<Int>()

  @Test
  fun insertElementWithIndexOutOfRange() {
    assertFails {
      linkedList.insert(0, -1)
    }

    assertFails {
      linkedList.insert(0, 1)
    }

    assertEquals("The list is empty.", "$linkedList")

    linkedList.insert(0, 0)

    assertFails {
      linkedList.insert(0, 5)
    }
  }

  @Test
  fun insertFirstElement() {
    linkedList.insert(0, 0)

    assertEquals("$linkedList", "0")
  }

  @Test
  fun insertTwoElementToTheEndOfList() {
    linkedList.insert(0, 0)
    linkedList.insert(1, 1)

    assertEquals("$linkedList", "0 -> 1")
  }

  @Test
  fun insertThreeElement() {
    linkedList.insert(0, 0)
    linkedList.insert(2, 1)
    linkedList.insert(1, 1)

    assertEquals("$linkedList", "0 -> 1 -> 2")
  }

  @Test
  fun insertFourElement() {
    linkedList.insert(0, 0)
    linkedList.insert(2, 1)
    linkedList.insert(1, 1)
    linkedList.insert(3, 3)

    assertEquals("$linkedList", "0 -> 1 -> 2 -> 3")
  }

  @Test
  fun atFirstElement() {
    linkedList.insert(0, 0)
    val actual = linkedList.at(0)

    assertEquals(0, actual)
  }

  @Test
  fun atFirstElementOfEmptyList() {
    val actual = linkedList.at(0)

    assertNull(actual)
  }

  @Test
  fun atEndOfList() {
    linkedList.insert(0, 0)
    linkedList.insert(2, 1)
    linkedList.insert(1, 1)
    linkedList.insert(3, 3)
    val actual = linkedList.at(3)

    assertEquals(3, actual)
  }

  @Test
  fun removeElementWithIndexOutOfRange() {
    assertFails {
      linkedList.remove(-1)
    }

    assertFails {
      linkedList.remove(1)
    }

    assertEquals("The list is empty.", "$linkedList")

    linkedList.insert(0, 0)

    assertFails {
      linkedList.remove(1)
    }
  }

  @Test
  fun removeFirstElement() {
    linkedList.insert(0, 0)
    linkedList.remove(0)

    assertEquals("The list is empty.", "$linkedList")
  }

  @Test
  fun removeSeconElementOfListHasTwoElement() {
    linkedList.insert(0, 0)
    linkedList.insert(1, 0)
    linkedList.remove(1)

    assertEquals("1", "$linkedList")
  }

  @Test
  fun removeSecondElementOfListHasThreeElement() {
    linkedList.insert(0, 0)
    linkedList.insert(1, 0)
    linkedList.insert(2, 0)
    linkedList.remove(1)

    assertEquals("2 -> 0", "$linkedList")
  }

  @Test
  fun removeLastElementOfListHasThreeElement() {
    linkedList.insert(0, 0)
    linkedList.insert(1, 0)
    linkedList.insert(2, 0)
    linkedList.remove(2)

    assertEquals("2 -> 1", "$linkedList")
  }

  @Test
  fun setHead() {
    class MockLinkedList : LinkedList<Int>() {
      fun setHeader(node: Node<Int>) {
        head = node
      }
    }

    val list = MockLinkedList()

    list.setHeader(Node(1))
    list.insert(1, 0)

    assertEquals("1 -> 1", "$list")
  }
}
