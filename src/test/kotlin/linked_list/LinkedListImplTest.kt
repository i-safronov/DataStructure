package linked_list

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class LinkedListImplTest {

    @Test
    fun `test add item, should return added item and change item size`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 5
        Assert.assertEquals(addedItem, linkedListImpl.add(addedItem))
        Assert.assertTrue(linkedListImpl.getSize() >= 1)
    }

    @Test
    fun `test get item, should return item by index`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 5
        Assert.assertEquals(addedItem, linkedListImpl.add(addedItem))
    }

    @Test(expected = IllegalStateException::class)
    fun `test get item from empty list`() {
        val linkedListImpl = LinkedListImpl<Int>()
        linkedListImpl.get(0)
    }

    @Test(expected = IllegalStateException::class)
    fun `test get item by wrong index, should throw a exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        linkedListImpl.get(999)
    }

    @Test
    fun `test delete item by index, should delete and then return deleted item`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        Assert.assertTrue(addedItem == linkedListImpl.delete(0))
        Assert.assertTrue(linkedListImpl.getSize() < 1)
    }

    @Test(expected = IllegalStateException::class)
    fun `test delete item by wrong index, should throw a exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        linkedListImpl.delete(999)
    }

    @Test
    fun `test delete twice, should delete two items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        val addedItem2 = 2
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        Assert.assertTrue(addedItem2 == linkedListImpl.add(addedItem2))
        Assert.assertTrue(linkedListImpl.getSize() >= 2)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem)
        Assert.assertTrue(linkedListImpl.delete(0) == addedItem2)
    }

    @Test
    fun `test add and delete item twice`() {
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
    fun `test clear all items, should delete all items`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.add(addedItem)
        linkedListImpl.clearAll()
        Assert.assertTrue(linkedListImpl.getSize() == 0)
    }

    @Test(expected = IllegalStateException::class)
    fun `test get item after clear all items, should throw exception`() {
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
    fun `test add too much items, should get item at some position without null`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        repeat(200) {
            linkedListImpl.add(addedItem)
        }
        Assert.assertTrue(linkedListImpl.getSize() == 200)
        repeat(199) {
            Assert.assertTrue(linkedListImpl.get(it) == addedItem)
        }
    }

    @Test
    fun `test add items after that get all items and delete all items twice, should works correctly`() {
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

}