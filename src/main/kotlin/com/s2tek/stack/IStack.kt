package com.s2tek.stack

interface IStack<T> {
    fun pop(): T?
    fun push(value: T)
}
