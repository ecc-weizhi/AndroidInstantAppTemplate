package app.eccweizhi.androidinstantapptemplate.base.logger

import io.reactivex.subjects.BehaviorSubject
import java.util.*
import java.util.concurrent.atomic.AtomicLong


class AppLog(private val capacity: Int = 100) {
    val subject: BehaviorSubject<List<Message>> = BehaviorSubject.createDefault(emptyList)
    private val list = LinkedList<Message>()
    private val idCounter = AtomicLong(0)

    init {
        if (capacity == 0) throw IllegalArgumentException("Capacity must be more than 0")
    }

    fun log(tag: String, message: String) {
        val size = list.size
        list.offerLast(Message(idCounter.incrementAndGet(), tag, message))
        if (size == capacity) {
            list.pollFirst()
        }

        subject.onNext(list)
    }

    companion object {
        private val emptyList = listOf<Message>()
    }
}