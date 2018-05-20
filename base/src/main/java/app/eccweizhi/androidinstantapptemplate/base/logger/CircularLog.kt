package app.eccweizhi.androidinstantapptemplate.base.logger


class CircularLog(val capacity: Int = 100) {
    private val list: ArrayList<Message> = ArrayList(capacity)
    private var headIndex = 0
    private var tailIndex = 0
    private var internalSize = 0

    val size: Int
        get() = internalSize

    fun get(index: Int): Message {
        val rawIndex = convertToRawIndex(index)
        return list[rawIndex]
    }

    fun isEmpty(): Boolean {
        return internalSize == 0
    }

    fun enqueue(message: Message) {
        list[tailIndex] = message.copy()
        if (internalSize == (capacity - 1)) {
            headIndex = (headIndex + 1) % capacity
        } else {
            tailIndex = (tailIndex + 1) % capacity
            internalSize++
        }
    }

    fun dequeue(): Message? {
        if (internalSize == 0) {
            return null
        }

        val message = list[headIndex]
        headIndex = (headIndex + 1) % capacity
        internalSize--

        return message
    }

    private fun convertToRawIndex(circularIndex: Int): Int {
        if (circularIndex >= size || circularIndex < 0) {
            throw ArrayIndexOutOfBoundsException("size: $size, index: $circularIndex")
        }

        return if (headIndex > tailIndex) {
            // wrap around
            (headIndex + circularIndex) % capacity
        } else {
            // no wrap around
            circularIndex + headIndex
        }
    }

    private fun convertToCircularIndex(rawIndex: Int): Int {
        return if (headIndex > tailIndex) {
            // wrap around
            when (rawIndex) {
                in headIndex..(capacity - 1) -> rawIndex - headIndex
                in 0..tailIndex -> (capacity - headIndex + 1) + rawIndex
                else -> throw ArrayIndexOutOfBoundsException("size: $size, index: $rawIndex")
            }
        } else {
            // no wrap around
            when (rawIndex) {
                in headIndex..tailIndex -> rawIndex - headIndex
                else -> throw ArrayIndexOutOfBoundsException("size: $size, index: $rawIndex")
            }
        }
    }
}