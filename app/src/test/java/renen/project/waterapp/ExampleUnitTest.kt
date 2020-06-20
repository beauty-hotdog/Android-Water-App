package renen.project.waterapp

import org.junit.Test

import org.junit.Assert.*
import renen.project.waterapp.util.isLastElement

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun lastElement_test(){
        val a = "a"
        val b = "b"
        val c = "c"
        val list = listOf<String>(a, b, c)
        assertEquals(false, isLastElement(position = list.indexOf(a), listSize = list.size))
        assertEquals(false, isLastElement(position = list.indexOf(b), listSize = list.size))
        assertEquals(true, isLastElement(position = list.indexOf(c), listSize = list.size))
    }
}