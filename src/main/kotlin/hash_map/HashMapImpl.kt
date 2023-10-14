package hash_map

import hash_map.model.HashMapItem
import linked_list.data.LinkedListNode

class HashMapImpl<K, V>: HashMapInt<K, V> {

    private var maxSize = 15
    private var size = 0
    private var loadFactor = 0.75F
    private var items = Array<LinkedListNode<HashMapItem<K, V>>?>(maxSize + 1) {
        null
    }

    override fun add(key: K, value: V): V {
        val hashCode = key.hashCode()
        if (isNeedToResize()) resize()
        val index = getIndex(hashCode)
        return addNewValue(
            index = index,
            key = key,
            value = value,
            hashCode = hashCode
        )
    }

    override fun get(key: K): V? {
        val hashCode = key.hashCode()
        val index = getIndex(hashCode)
        return getItem(index = index, key = key)
    }

    override fun remove(key: K): V? {
        val hashCode = key.hashCode()
        val index = getIndex(hashCode)
        return removeItemByIndexAndKey(index = index, key = key)
    }

    override fun size(): Int {
        return size
    }

    private fun isNeedToResize(): Boolean {
        return (size / maxSize).toFloat() >= loadFactor
    }

    private fun resize() {
        maxSize *= 2
        val newArray = Array<LinkedListNode<HashMapItem<K, V>>?>(maxSize + 1) { null  }
        items.forEachIndexed { index, hashMapItem ->
            newArray[index] = hashMapItem
        }
        items = newArray
    }

    private fun getIndex(hashCode: Int) = (hashCode and maxSize)

    private fun addNewValue(index: Int, key: K, value: V, hashCode: Int): V {
        if (items[index] == null) {
            val newItem = LinkedListNode(data = HashMapItem(key = key, value = value, hashCode = hashCode), next = null)
            items[index] = newItem
            size++
            return newItem.data.value
        } else if (items[index]?.data?.key == key) {
            val newItem = LinkedListNode(data = HashMapItem(key = key, value = value, hashCode = hashCode), next = items[index]?.next)
            items[index] = newItem
            size++
            return newItem.data.value
        } else {
            val currentItem = items[index]
            val newItem = LinkedListNode(data = HashMapItem(key = key, value = value, hashCode = hashCode), null)
            while (currentItem?.next != null) {
                currentItem.next = currentItem.next?.next
            }
            currentItem?.next = newItem
            size++
            return newItem.data.value
        }
    }

    private fun getItem(index: Int, key: K): V? {
        val currentItem: LinkedListNode<HashMapItem<K, V>>? = items[index]
        while (currentItem != null) {
            if (currentItem.data.key == key) return currentItem.data.value
            else {
                currentItem.data = currentItem.next?.data!!
            }
        }
        throw IllegalStateException("Item didn't found, make sure that you set the correct key, key: $key")
    }

    private fun removeItemByIndexAndKey(index: Int, key: K): V? {
        if (items[index]?.data?.key == key) {
            val oldData = items[index]?.data?.value
            items[index] = items[index]?.next
            size--
            return oldData
        } else {
            val currentItem = items[index]
            while (currentItem?.next != null) {
                if (currentItem.next?.data?.key == key) {
                    val oldData = currentItem.next?.data?.value
                    currentItem.next = currentItem.next?.next
                    size--
                    return oldData
                }
            }
        }
        throw IllegalStateException("Item didn't found, make sure that you set the correct key, key: $key")
    }

}