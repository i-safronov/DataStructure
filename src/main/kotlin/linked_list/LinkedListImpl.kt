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
        if (index <= size - 1 && index >= 0 && head != null) {
            var count = 0
            var currentItem = head
            while (currentItem != null) {
                if (count == index) {
                    return currentItem.data
                } else {
                    currentItem = currentItem.next
                    ++count
                }
            }
            throw IllegalStateException("No item found for this index: $index")
        } else {
            throw IllegalStateException("Index is out of available area,\nindex: $index, size: ${size - 1}")
        }
    }

    override fun delete(index: Int): T? {
        if (index <= size - 1 && index >= 0 && head != null) {
            var count = 0
            var currentItem = head
            if (index == 0) {
                head = head?.next
                --size
                return currentItem?.data
            } else {
                while (currentItem?.next != null) {
                    if (count + 1 == index) {
                        currentItem.next = currentItem.next?.next
                        --size
                        return currentItem.next?.data
                    }
                    currentItem = currentItem.next
                    ++count
                }
                throw IllegalStateException("No item found for this index: $index")
            }
        } else {
            throw IllegalStateException("Index is out of available area,\nindex: $index, size: ${size - 1}")
        }
    }

    override fun clearAll() {
        head = null
    }

    fun getSize() = size

}