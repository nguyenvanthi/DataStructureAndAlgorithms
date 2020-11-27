package com.s2tek

import com.s2tek.linkedlist.LinkedList
import com.s2tek.linkedlist.LinkedListIterable

fun main() {
    val linkedList = LinkedList<Int>()
    val linkedListIterable = LinkedListIterable<Int>()

    linkedList.insert(1, 0)
    linkedList.insert(3, 0)
    linkedList.insert(2, 1)
    linkedList.insert(0, 3)

    println(linkedList)

    linkedList.remove(0)
    linkedList.remove(1)
    linkedList.remove(1)

    println(linkedList)

    linkedListIterable.insert(1, 0)
    linkedListIterable.insert(2, 0)

    println(linkedListIterable)
    val iterator = linkedListIterable.iterator()

    while (iterator.hasNext()) {
        println("${iterator.hasNext()} ${iterator.next()}")
    }
}
