package hash_map.model

data class HashMapItem<K, V>(
    val key: K,
    var value: V,
    var hashCode: Int
)
