package hash_map.model

import linked_list.data.LinkedListNode

data class HashMapItem<K, V>(
    val key: K,
    var value: LinkedListNode<V>,
    var hashCode: Int
)
