package linked_list

interface LinkedListInt<T> {

    fun add(item: T): T
    fun get(index: Int): T
    fun delete(index: Int): T?
    fun clearAll()
    fun contains(item: T): Boolean
    fun toList(): List<T>
    fun size(): Int

}