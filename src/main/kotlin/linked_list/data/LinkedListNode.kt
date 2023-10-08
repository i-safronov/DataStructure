package linked_list.data

data class LinkedListNode<T>(
    var data: T,
    var next: LinkedListNode<T>? = null
)
