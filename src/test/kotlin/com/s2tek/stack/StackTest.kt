package com.s2tek.stack

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class StackTest {
    private val stack = Stack<Int>()

    @Test
    fun popAnEmptyStack() {
        val actual = stack.pop()

        assertNull(actual)
    }

    @Test
    fun pushAndPop() {
        stack.push(1)
        val actual = stack.pop()

        assertEquals(1, actual)
    }
}
