package linked_list

interface LinkedListInt<T> {

    fun add(item: T): T
    fun addAt(index: Int, item: T): T
    fun get(index: Int): T
    fun delete(index: Int): T?
    fun deleteItem(item: T): Boolean
    fun clearAll()
    fun contains(item: T): Boolean
    fun toList(): List<T>
    fun isEmpty(): Boolean
    fun size(): Int

}