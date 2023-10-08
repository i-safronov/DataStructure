package queue

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class QueueImplTest {

    @Test
    fun `test, add item, should add and return added item`() {
        val queueImpl = QueueImpl<Int>()
        val addedItem = 10
        assertEquals(addedItem, queueImpl.add(addedItem))
    }

    @Test
    fun `test, add item in the queue that's not empty, should add and return added item`() {
        val queueImpl = QueueImpl<Int>()
        val addedItem = 10
        repeat(9) {
            queueImpl.add(it)
        }
        assertEquals(addedItem, queueImpl.add(addedItem))
        assertTrue(queueImpl.size() >= 10)
    }

    @Test
    fun `test, remove added item, should return and delete returned item`() {
        val queueImpl = QueueImpl<Int>()
        val addedItem = 10
        assertEquals(addedItem, queueImpl.add(addedItem))
        assertEquals(addedItem, queueImpl.remove())
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun `test, remove item from empty queue, should throw exception`() {
        val queueImpl = QueueImpl<Int>()
        queueImpl.remove()
    }

    @Test
    fun `test, add and remove item several time`() {
        val queueImpl = QueueImpl<Int>()
        repeat(2) {
            assertEquals(it, queueImpl.add(it))
        }
        assertEquals(0, queueImpl.remove())
        assertEquals(1, queueImpl.remove())
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun `test, remove more than pushed, should throw exception`() {
        val queueImpl = QueueImpl<Int>()
        queueImpl.add(1)
        queueImpl.remove()
        queueImpl.remove()
    }

}