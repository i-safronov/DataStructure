package linked_list

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LinkedListImplTest {

    @Test
    fun `test, add item, should return added item and change item size`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 5
        Assert.assertEquals(addedItem, linkedListImpl.add(addedItem))
        Assert.assertTrue(linkedListImpl.size() >= 1)
    }

    @Test
    fun `test, get item, should return item by index`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 5
        Assert.assertEquals(addedItem, linkedListImpl.add(addedItem))
    }

    @Test(expected = IllegalStateException::class)
    fun `test, get item from empty linked linked list`() {
        val linkedListImpl = LinkedListImpl<Int>()
        linkedListImpl.get(0)
    }

    @Test(expected = IllegalStateException::class)
    fun `test, get item by wrong index, should throw a exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        linkedListImpl.get(999)
    }

    @Test
    fun `test, delete item by index, should delete and then return deleted item`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        Assert.assertTrue(addedItem == linkedListImpl.delete(0))
        Assert.assertTrue(linkedListImpl.size() < 1)
    }

    @Test(expected = IllegalStateException::class)
    fun `test, delete item by wrong index, should throw a exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        linkedListImpl.delete(999)
    }

    @Test
    fun `test, delete twice, should delete two items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        val addedItem2 = 2
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        Assert.assertTrue(addedItem2 == linkedListImpl.add(addedItem2))
        Assert.assertTrue(linkedListImpl.size() >= 2)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem2)
    }

    @Test
    fun `test, add and delete item twice`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(addedItem)
        Assert.assertTrue(linkedListImpl.get(0) == addedItem)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem)
        linkedListImpl.add(addedItem)
        Assert.assertTrue(linkedListImpl.get(0) == addedItem)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem)
    }

    @Test
    fun `test, clear all items, should delete all items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.clearAll()
        Assert.assertTrue(linkedListImpl.size() == 0)
    }

    @Test(expected = IllegalStateException::class)
    fun `test, get item after clear all items, should throw exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.clearAll()
        linkedListImpl.get(0)
    }

    @Test
    fun `test, add too much items, should get item at some position without null`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        repeat(200) {
            linkedListImpl.add(addedItem)
        }
        Assert.assertTrue(linkedListImpl.size() == 200)
        repeat(199) {
            Assert.assertTrue(linkedListImpl.get(it) == addedItem)
        }
    }

    @Test
    fun `test, add items after that get all items and delete all items twice, should works correctly`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        for (i in 0 .. 1) {
            repeat(200) {
                linkedListImpl.add(addedItem)
            }
            repeat(199) {
                assertEquals(linkedListImpl.get(it), addedItem)
            }
            linkedListImpl.clearAll()
        }
    }

    @Test
    fun `test, is contains some item in the linked list, should return true`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(addedItem)
        assertTrue(linkedListImpl.contains(addedItem))
    }

    @Test
    fun `test, is contains some item in the linked list, should return false 'cause item is not in the linked list`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(999)
        assertTrue(!(linkedListImpl.contains(addedItem)))
    }

    @Test
    fun `test, is contains some item in the list, should return true also when there are some the same items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        repeat(10) {
            linkedListImpl.add(addedItem)
        }
        assertTrue(linkedListImpl.contains(addedItem))
    }

    @Test
    fun `test, to list, should return simple list with the same items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        repeat(100) {
            linkedListImpl.add(it)
        }
        val linkedSize = linkedListImpl.size()
        val simpleList: List<Int> = linkedListImpl.toList()
        repeat(100) {
            assertEquals(simpleList[it], it)
        }
        assertEquals(linkedSize, simpleList.size)
    }

    @Test
    fun `test, to list, should return empty list 'cause there is a empty linked list`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val emptyList: List<Int> = linkedListImpl.toList()
        assertEquals(emptyList.size, 0)
        assertEquals(linkedListImpl.size(), 0)
    }

    @Test
    fun `test, to list, add items after this call to list twice`() {
        val linkedListImpl = LinkedListImpl<Int>()
        repeat(2) {
            repeat(100) {
                linkedListImpl.add(it)
            }
            val list: List<Int> = linkedListImpl.toList()
            repeat(100) {
                assertEquals(list[it], it)
            }
        }
    }

    @Test
    fun `test, is empty, should return false 'cause linked list is not empty`() {
        val linkedListImpl = LinkedListImpl<Int>()
        linkedListImpl.add(1)
        assertTrue(!linkedListImpl.isEmpty())
    }

    @Test
    fun `test, is empty, should return true 'cause linked list is empty`() {
        val linkedListImpl = LinkedListImpl<Int>()
        assertTrue(linkedListImpl.isEmpty())
    }

    @Test
    fun `test, delete item, should delete all items with the same data and return deleted item`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        repeat(4) {
            linkedListImpl.add(it)
        }
        linkedListImpl.add(addedItem)
        val value: Boolean = linkedListImpl.deleteItem(addedItem)
        assertTrue(!linkedListImpl.contains(addedItem))
        assertTrue(value)
    }

    @Test
    fun `test, delete item, should return false 'cause linked list does not have the same item`() {
        val linkedListImpl = LinkedListImpl<Int>()
        repeat(4) {
            linkedListImpl.add(it)
        }
        assertTrue(!linkedListImpl.deleteItem(999))
    }

    @Test
    fun `test, delete item, should return false 'cause linked list is empty`() {
        val linkedListImpl = LinkedListImpl<Int>()
        assertTrue(!linkedListImpl.deleteItem(999))
    }

    @Test
    fun `test, add at, should add item at some index`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedPosition = linkedListImpl.size() - 1
        val addedItem = 999
        repeat(20) {
            linkedListImpl.add(it)
        }
        linkedListImpl.addAt(addedPosition, addedItem)
        assertEquals(addedItem, linkedListImpl.get(addedPosition))
        assertTrue(linkedListImpl.size() >= 20)
    }

    @Test(expected = IllegalStateException::class)
    fun `test, add at, should throw exception 'cause index is out of linked list`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedPosition = 100302
        val addedItem = 999
        repeat(20) {
            linkedListImpl.add(it)
        }
        linkedListImpl.addAt(addedPosition, addedItem)
    }

    @Test
    fun `test, add at, add item at 0 index when linked list is empty`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedPosition = 0
        val addedItem = 1337
        linkedListImpl.addAt(addedPosition, addedItem)
        assertEquals(addedItem, linkedListImpl.get(addedPosition))
        assertTrue(linkedListImpl.size() > 0)
    }

    @Test
    fun `test, add at, add item at 9 index when linked list is empty`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedPosition = 9
        val addedItem = 1337
        linkedListImpl.addAt(addedPosition, addedItem)
        assertEquals(addedItem, linkedListImpl.get(0))
        assertTrue(linkedListImpl.size() > 0)
    }

}