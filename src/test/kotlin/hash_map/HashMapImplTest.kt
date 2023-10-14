package hash_map

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HashMapImplTest {

    @Test
    fun `test, add item, should add and return added item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        val addedItem = 5
        val key = 1
        assertEquals(addedItem, hashMapImpl.add(key, addedItem))
    }

    @Test
    fun `test, add item in the map that's not empty, should add and return added item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        val value = 1337
        val key = 2
        assertEquals(1, hashMapImpl.add(1, 1))
        assertEquals(value, hashMapImpl.add(key, value))
    }

    @Test
    fun `test, add item using the same key, should replace old value and save new value and return added item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        val value = 1337
        val key = 2
        val newValue = 3
        assertEquals(value, hashMapImpl.add(key, value))
        assertEquals(value, hashMapImpl.get(key))
        assertEquals(newValue, hashMapImpl.add(key, newValue))
        assertEquals(newValue, hashMapImpl.get(key))
    }

    @Test
    fun `test, get item, should return item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        val value = 1337
        val key = 2
        assertEquals(value, hashMapImpl.add(key, value))
        assertEquals(value, hashMapImpl.get(key))
    }

    @Test
    fun `test, get items using different keys, should return items`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        assertEquals(1, hashMapImpl.add(key = 1, value = 1))
        assertEquals(2, hashMapImpl.add(key = 2, value = 2))
        assertEquals(1, hashMapImpl.get(1))
        assertEquals(2, hashMapImpl.get(2))
    }

    @Test
    fun `test, add new item, should change hash map size`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        hashMapImpl.add("Hello", 5)
        assertTrue(hashMapImpl.size() != 0)
    }

    @Test
    fun `test, size for new hash map, should be equals 0`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        assertTrue(hashMapImpl.size() == 0)
    }

    @Test
    fun `test, size changing, should size increments when adding elements`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        hashMapImpl.add("Hello", 5)
        assertTrue(1 == hashMapImpl.size())
        hashMapImpl.add("Goodbye", 5)
        assertTrue(2 == hashMapImpl.size())
    }

    @Test(expected = IllegalStateException::class)
    fun `test, get item by key that's not exists, should throw exception`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        assertTrue(hashMapImpl.get("ajsldkfjklas") == null)
    }

    @Test
    fun `test, add item by the same hash code, should not overwrite items`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        hashMapImpl.add("Ea", 5)
        hashMapImpl.add("FB", 6)
        assertEquals(5, hashMapImpl.get("Ea"))
        assertEquals(6, hashMapImpl.get("FB"))
    }

    @Test(expected = IllegalStateException::class)
    fun `test, remove item that's not exists, should throw exception`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        hashMapImpl.remove("Hello")
        assertEquals(0, hashMapImpl.size())
    }

    @Test
    fun `test, remove items, should decrement size and delete item`() {
        val hashMapImpl: HashMapInt<String, Int> = HashMapImpl<String, Int>()
        hashMapImpl.add("Hello", 5)
        hashMapImpl.add("Goodbye", 6)
        hashMapImpl.remove("Hello")
        assertEquals(1, hashMapImpl.size())
        hashMapImpl.remove("Goodbye")
        assertEquals(0, hashMapImpl.size())
    }

    @Test
    fun `test, resize when adding too much items`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        repeat(200) {
            hashMapImpl.add(it, it)
        }
        assertTrue(hashMapImpl.size() > 16)
    }

    @Test
    fun `test, add and remove item too much times`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        repeat(200) {
            assertEquals(it, hashMapImpl.add(it, it))
            assertEquals(it, hashMapImpl.remove(it))
        }
    }

    @Test
    fun `test, add item by the same items a lot of times, should correct replace old item and write new item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl<Int, Int>()
        val key = 9812
        repeat(200) {
            hashMapImpl.add(key = key, it)
        }
        assertEquals(199, hashMapImpl.get(key))
    }

    @Test
    fun `test, change size when adding items check, should increment size after added item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl()
        repeat(100) {
            assertEquals(it, hashMapImpl.add(it, it))
        }
        assertTrue(hashMapImpl.size() >= 100)
    }

    @Test
    fun `test, remove first item, should return removed item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl()
        val addedItem = 1
        assertEquals(addedItem, hashMapImpl.add(1, addedItem))
        assertTrue(hashMapImpl.size() >= 1)
        assertEquals(addedItem, hashMapImpl.remove(1))
        assertTrue(hashMapImpl.size() < 1)
    }

    @Test
    fun `test, remove last item, should return removed item`() {
        val hashMapImpl: HashMapInt<Int, Int> = HashMapImpl()
        val addedItem = 2
        assertEquals(1, hashMapImpl.add(1, 1))
        assertEquals(addedItem, hashMapImpl.add(2, addedItem))
        assertTrue(hashMapImpl.size() >= 2)
        assertEquals(addedItem, hashMapImpl.remove(2))
        assertTrue(hashMapImpl.size() <= 1)
    }

}