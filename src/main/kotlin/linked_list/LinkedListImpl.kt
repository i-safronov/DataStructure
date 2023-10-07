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

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged. **/
    override fun deleteItem(item: T): Boolean {
        return if (contains(item)) {
            var currentItem = head
            if (head?.data == item) {
                head = head?.next
            } else {
                while (currentItem?.next != null) {
                    if (currentItem.next?.data == item) {
                        currentItem.next = currentItem.next?.next
                    } else {
                        currentItem = currentItem.next
                    }
                }
            }
            true
        } else {
            false
        }
    }

    override fun clearAll() {
        head = null
        size = 0
    }

    override fun contains(item: T): Boolean {
        var currentItem = head
        while (currentItem != null) {
            if (currentItem.data == item) {
                return true
            }
            currentItem = currentItem.next
        }
        return false
    }

    override fun toList(): List<T> {
        val mutableList = mutableListOf<T>()
        var currentItem = head

        while (currentItem != null) {
            mutableList.add(currentItem.data)
            currentItem = currentItem.next
        }

        return mutableList
    }

    override fun isEmpty(): Boolean {
        return head == null
    }

    override fun size() = size

}