package app.eccweizhi.androidinstantapptemplate.base.logger


class CircularLog(val capacity: Int = 100) {
    init {
        if (capacity == 0) throw IllegalArgumentException("Capacity must be more than 0")
    }

    private val list: Array<Message?> = Array(capacity) { null }
    private var firstElementIndex = -1
    private var lastElementIndex = -1
    private var internalSize = 0

    val size: Int
        get() = internalSize

    fun get(index: Int): Message? {
        val rawIndex = convertToRawIndex(index)
        return list[rawIndex]
    }

    fun enqueue(message: Message) {
        // lastElementIndex
        val newLastElementIndex = (lastElementIndex + 1) % capacity

        // firstElementIndex
        val newFirstElementIndex = when {
            firstElementIndex == -1 -> 0
            internalSize == capacity -> (firstElementIndex + 1) % capacity
            else -> firstElementIndex
        }

        // internalSize
        val newInternalSize = if (internalSize < capacity) {
            internalSize + 1
        } else {
            internalSize
        }

        list[newLastElementIndex] = message.copy()
        lastElementIndex = newLastElementIndex
        firstElementIndex = newFirstElementIndex
        internalSize = newInternalSize
    }

    fun dequeue(): Message? {
        if (internalSize == 0) {
            return null
        }

        val message = list[firstElementIndex]

        // firstElementIndex
        firstElementIndex = if (internalSize == 1) {
            -1
        } else {
            (firstElementIndex + 1) % capacity
        }

        // lastElementIndex
        lastElementIndex = if (internalSize == 1) {
            -1
        } else {
            lastElementIndex
        }

        // internalSize
        internalSize++

        return message
    }

    private fun convertToRawIndex(circularIndex: Int): Int {
        if (circularIndex >= size || circularIndex < 0) {
            throw ArrayIndexOutOfBoundsException("size: $size, index: $circularIndex")
        }

        return if (firstElementIndex > lastElementIndex) {
            // wrap around
            (firstElementIndex + circularIndex) % capacity
        } else {
            // no wrap around
            firstElementIndex + circularIndex
        }
    }

    private fun convertToCircularIndex(rawIndex: Int): Int {
        return if (firstElementIndex > lastElementIndex) {
            // wrap around
            when (rawIndex) {
                in firstElementIndex..(capacity - 1) -> rawIndex - firstElementIndex
                in 0..lastElementIndex -> (capacity - firstElementIndex) + rawIndex
                else -> throw ArrayIndexOutOfBoundsException("size: $size, index: $rawIndex")
            }
        } else {
            // no wrap around
            when (rawIndex) {
                in firstElementIndex..lastElementIndex -> rawIndex - firstElementIndex
                else -> throw ArrayIndexOutOfBoundsException("size: $size, index: $rawIndex")
            }
        }
    }
}