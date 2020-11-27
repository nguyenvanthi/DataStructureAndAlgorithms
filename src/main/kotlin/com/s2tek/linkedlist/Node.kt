package com.s2tek.linkedlist

data class Node<T>(val value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}
