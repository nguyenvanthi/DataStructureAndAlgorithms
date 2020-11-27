package com.s2tek

import com.s2tek.linkedlist.LinkedList

fun main() {
    val linkedList = LinkedList<Int>()

    linkedList.insert(1, 0)
    linkedList.insert(3, 0)
    linkedList.insert(2, 1)
    linkedList.insert(0, 3)

    println(linkedList)

    linkedList.remove(0)
    linkedList.remove(1)
    linkedList.remove(1)

    println(linkedList)
}
