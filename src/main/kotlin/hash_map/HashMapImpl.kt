package hash_map

import hash_map.model.HashMapItem
import linked_list.data.LinkedListNode

/*
* 5 and 5 - побитовое сложение между 5 и 5
* */

class HashMapImpl<K, V>: HashMapInt<K, V> {

    private var maxSize = 16
    private var size = 0
    private var loadFactor = 0.75F
    private var items = Array<HashMapItem<K, V>?>(maxSize) {
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
        TODO("Not yet implemented")
    }

    override fun remove(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    private fun isNeedToResize(): Boolean {
        return (size / maxSize).toFloat() >= loadFactor
    }

    private fun resize() {
        maxSize *= 2
        val newArray = Array<HashMapItem<K, V>?>(maxSize) { null }
        items.forEachIndexed { index, hashMapItem ->
            newArray[index] = hashMapItem
        }
        items = newArray
    }

    private fun getIndex(hashCode: Int) = (hashCode and maxSize)

    private fun addNewValue(index: Int, key: K, value: V, hashCode: Int): V {
        if (items[index] == null) {
            val newItem = HashMapItem(key = key, value = LinkedListNode(value, null), hashCode = hashCode)
            items[index] = newItem
            size++
            return newItem.value.data
        } else if (items[index]?.key == key) {
            val newItem = HashMapItem(key = key, value = LinkedListNode(value, items[index]?.value?.next), hashCode = hashCode)
            items[index] = newItem
            size++
            return newItem.value.data
        } else {
            val currentItem = items[index]
            val newItem = LinkedListNode(data = value, null)
            while (currentItem?.value?.next != null) {
                currentItem.value = currentItem.value.next!!
            }
            currentItem?.value?.next = newItem
            size++
            return newItem.data
        }
    }

}