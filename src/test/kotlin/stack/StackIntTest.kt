package stack

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StackIntTest {

    @Test
    fun `test, push item in the empty stack, should push and return pushed item`() {
        val stackInt = StackImpl<Int>()
        val addedItem = 9
        assertEquals(addedItem, stackInt.push(addedItem))
    }

    @Test
    fun `test, push item in the stack that's not empty, should push and return pushed item`() {
        val stackInt = StackImpl<Int>()
        val addedItem = 9
        repeat(5) {
            stackInt.push(it)
        }
        assertEquals(addedItem, stackInt.push(addedItem))
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun `test, pop item from the empty stack, should throw exception 'cause stack is empty`() {
        val stackInt = StackImpl<Int>()
        stackInt.pop()
    }

    @Test
    fun `test, pop item from the stack that's not empty, should return first item`() {
        val stackInt = StackImpl<Int>()
        stackInt.push(1)
        assertEquals(1, stackInt.pop())
        assertTrue(stackInt.size() == 0)
    }

    @Test
    fun `test, push and pop, should return pushed item`() {
        val stackInt = StackImpl<Int>()
        stackInt.push(1)
        assertEquals(1, stackInt.pop())
        assertTrue(stackInt.size() == 0)
    }

    @Test
    fun `test, push and pop 20 items, should push 20 items and after it pop 20 items`() {
        val stackInt = StackImpl<Int>()
        repeat(20) {
            stackInt.push(it)
        }
        assertTrue(stackInt.size() >= 20)
        for (i in 19 downTo 0 ) {
            assertEquals(i, stackInt.pop())
        }
        assertTrue(stackInt.size() == 0)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun `test, pop more than pushed, should throw exception`() {
        val stackInt = StackImpl<Int>()
        stackInt.push(10)
        val actual = stackInt.pop()
        assertEquals(10, actual)
        stackInt.pop()
    }

}