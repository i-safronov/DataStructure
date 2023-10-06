package linked_list

import linked_list.data.LinkedListNode

class LinkedListImpl<T>: LinkedListInt<T> {

    private var head: LinkedListNode<T>? = null
    private var size: Int = 0

    override fun add(item: T): T {
        return if (head == null) {
            head = LinkedListNode(item, null)
            ++size
            item
        } else {
            var currentNode = head
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = LinkedListNode(item, null)
            ++size
            item
        }
    }

    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): T {
        TODO("Not yet implemented")
    }

    fun getSize() = size

}