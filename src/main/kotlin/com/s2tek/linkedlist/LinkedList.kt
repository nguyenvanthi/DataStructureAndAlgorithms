package com.s2tek.linkedlist

interface ILinkedList<T> {
    fun insert(value: T, index: Int)
    fun at(index: Int): T?
    fun remove(index: Int)
}

typealias OnTraverse<T> = (currentNode: Node<T>, index: Int) -> Boolean

class LinkedList<T> : ILinkedList<T>{
    private var head: Node<T>? = null
    private var size = 0

    override fun insert(value: T, index: Int) {
        require(index in 0 until index + 1) {
            "Index is out of range."
        }

        size++

        val node = Node(value)

        when {
            head == null -> head = node
            index == 0 -> {
                node.next = head
                head = node
            }
            else -> {
                val onTraverse: OnTraverse<T> = {currentNode: Node<T>, currentIndex: Int ->
                    if (currentIndex == index - 1) {
                        node.next = currentNode.next
                        currentNode.next = node

                        false
                    } else {
                        true
                    }
                }

                traverse(onTraverse)
            }
        }
    }

    override fun at(index: Int): T? {
        var value: T? = null

        val onTraverse: OnTraverse<T> = { node: Node<T>, currentIndex: Int ->
            if (index == currentIndex) {
                value = node.value
                false
            } else {
                true
            }
        }

        traverse(onTraverse)

        return value
    }

    override fun remove(index: Int) {
        require(index in 0 until index + 1) {
            "Index is out of range."
        }

        if (index == 0) {
            head = head!!.next
        } else {
            val onTraverse: OnTraverse<T> = { node: Node<T>, currentIndex: Int ->
                when {
                    index - 1 == currentIndex && currentIndex == size - 1 -> {
                        node.next = null
                        false
                    }
                    index - 1 == currentIndex -> {
                        node.next = node.next!!.next
                        false
                    }
                    else -> {
                        true
                    }
                }
            }

            traverse(onTraverse)
        }
    }

    private fun traverse(onTraverse: OnTraverse<T>) {
        var currentNode = head
        var index = 0

        while (currentNode != null && onTraverse(currentNode, index)) {
            index++
            currentNode = currentNode.next
        }
    }

    override fun toString(): String {
        return if (size == 0) {
            "The list is empty."
        } else {
            "$head"
        }
    }
}