package com.s2tek.linkedlist

import org.junit.Test
import kotlin.test.assertEquals

class LinkedListTest {
    private val linkedList = LinkedList<Int>()

    @Test
    public fun insertFirstElement() {
        linkedList.insert(0, 0)

        assertEquals("$linkedList", "0")
    }
}
