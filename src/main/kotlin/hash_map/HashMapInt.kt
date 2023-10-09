package hash_map

interface HashMapInt<K, V> {

    fun add(key: K, value: V): V
    fun get(key: K): V?
    fun remove(key: K): V?
    fun size(): Int

}