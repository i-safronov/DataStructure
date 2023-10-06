package linked_list

import org.junit.Assert
import org.junit.Test

class LinkedListImplTest {

    @Test
    fun `test add item, should return added item and change item size`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 5
        Assert.assertEquals(addedItem, linkedListImpl.add(addedItem))
        Assert.assertTrue(linkedListImpl.size >= 1)
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
        Assert.assertTrue(linkedListImpl.size < 1)
    }

    @Test(expected = IllegalStateException::class)
    fun `test delete item by wrong index, should throw a exception`() {
        val linkedListImpl = LinkedListImpl<Int>()
        val addedItem = 1
        Assert.assertTrue(addedItem == linkedListImpl.add(addedItem))
        linkedListImpl.delete(999)
    }

}