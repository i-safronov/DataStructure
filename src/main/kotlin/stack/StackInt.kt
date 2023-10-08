package stack

interface StackInt<T> {

    fun push(item: T): T
    fun pop(): T
    fun size(): Int

}