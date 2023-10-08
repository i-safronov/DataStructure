package queue

interface QueueInt<T> {

    fun add(item: T): T
    fun remove(): T
    fun size(): Int

}