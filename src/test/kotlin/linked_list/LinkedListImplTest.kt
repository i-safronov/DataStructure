package linked_list

import org.junit.Assert
import org.junit.Test

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
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem2))
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

}