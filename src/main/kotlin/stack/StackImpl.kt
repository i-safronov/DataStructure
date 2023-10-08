package stack

class StackImpl<T>: StackInt<T> {

    private val mutableList = mutableListOf<T>()

    override fun push(item: T): T {
        mutableList.add(0, item)
        return item
    }

    override fun pop(): T {
        val item = mutableList.get(0)
        mutableList.removeAt(0)
        return item
    }

    override fun size(): Int {
        return mutableList.size
    }

}