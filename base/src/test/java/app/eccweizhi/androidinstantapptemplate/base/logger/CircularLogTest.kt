package app.eccweizhi.androidinstantapptemplate.base.logger

import org.junit.Assert.assertEquals
import org.junit.Test

class CircularLogTest {

    @Test
    fun empty_getSize() {
        val circularLog = CircularLog()
        assertEquals(0, circularLog.size)
    }

    @Test
    fun oneItem_getSize() {
        val circularLog = CircularLog()
        circularLog.enqueue(Message(1, "tag", "content"))
        assertEquals(1, circularLog.size)
    }

    @Test
    fun manyItem_getSize() {
        val circularLog = CircularLog()
        for(i in 1..10){
            circularLog.enqueue(Message(i.toLong(), "tag", "content"))
        }
        assertEquals(10, circularLog.size)
    }

    @Test
    fun get() {
        val circularLog = CircularLog()
        for(i in 1..10){
            circularLog.enqueue(Message(i.toLong(), "tag", "content"))
        }

        assertEquals(Message(3, "tag", "content"), circularLog.get(2))
    }

    @Test
    fun enqueue_shouldFollowSequence() {
        val circularLog = CircularLog()
        for(i in 1..10){
            circularLog.enqueue(Message(i.toLong(), "tag", "content"))
        }

        for(i in 1..10){
            assertEquals(Message(i.toLong(), "tag", "content"), circularLog.get(i-1))
        }
    }

    @Test
    fun dequeue_shouldFollowSequence() {
        val circularLog = CircularLog()
        for(i in 1..10){
            circularLog.enqueue(Message(i.toLong(), "tag", "content"))
        }

        for(i in 1..10){
            assertEquals(Message(i.toLong(), "tag", "content"), circularLog.dequeue())
        }
    }

    @Test
    fun getCapacity() {
        val circularLog = CircularLog(12)
        assert(circularLog.capacity == 12)
    }
}