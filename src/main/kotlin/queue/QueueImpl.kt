package queue

class QueueImpl<T>: QueueInt<T> {

    private val mutableList = mutableListOf<T>()

    override fun add(item: T): T {
        mutableList.add(item)
        return item
    }

    override fun remove(): T {
        val item = mutableList[0]
        mutableList.removeAt(0)
        return item
    }

    override fun size(): Int {
        return mutableList.size
    }

}