package stack

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StackImplTest {

    @Test
    fun `test, push item in the empty stack, should push and return pushed item`() {
        val stackImpl = StackImpl<Int>()
        val addedItem = 9
        assertEquals(addedItem, stackImpl.push(addedItem))
    }

    @Test
    fun `test, push item in the stack that's not empty, should push and return pushed item`() {
        val stackImpl = StackImpl<Int>()
        val addedItem = 9
        repeat(5) {
            stackImpl.push(it)
        }
        assertEquals(addedItem, stackImpl.push(addedItem))
    }

    @Test(expected = IllegalStateException::class)
    fun `test, pop item from the empty stack, should throw exception 'cause stack is empty`() {
        val stackImpl = StackImpl<Int>()
        stackImpl.pop()
    }

    @Test
    fun `test, pop item from the stack that's not empty, should return first item`() {
        val stackImpl = StackImpl<Int>()
        stackImpl.push(1)
        assertEquals(1, stackImpl.pop())
        assertTrue(stackImpl.size() >= 1)
    }

    @Test
    fun `test, push and pop, should return pushed item`() {
        val stackImpl = StackImpl<Int>()
        stackImpl.push(1)
        assertEquals(1, stackImpl.pop())
        assertTrue(stackImpl.size() >= 1)
    }

    @Test
    fun `test, push and pop 20 items, should push 20 items and after it pop 20 items`() {
        val stackImpl = StackImpl<Int>()
        repeat(20) {
            stackImpl.push(it)
        }
        assertTrue(stackImpl.size() >= 20)
        for (i in 20 downTo 0 ) {
            assertEquals(i, stackImpl.pop())
        }
        assertTrue(stackImpl.size() == 20)
    }

    @Test(expected = IllegalStateException::class)
    fun `test, pop more than pushed, should throw exception`() {
        val stackImpl = StackImpl<Int>()
        stackImpl.push(10)
        val actual = stackImpl.pop()
        assertEquals(10, actual)
        stackImpl.pop()
    }

}