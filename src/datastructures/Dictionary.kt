package datastructures

import java.util.LinkedList

object DictionaryTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val dic: Dictionary<Int, String> = DictionaryImpl()

        dic.put(0, "Hey")
        dic.put(1, "Hey1")
        dic.put(2, "Hey2")
        dic.put(2, "Hey3")

        println(dic.size)
    }
}

interface Dictionary<A, B> {
    val size: Int
    fun put(key: A, value: B)
    fun get(key: A): B?
}

class DictionaryImpl: Dictionary<Int, String> {

    private val internalSize = 1000
    private val array = Array(internalSize) { LinkedList<DictionaryNode>() }
    override var size: Int = 0
        private set

    override fun get(key: Int): String? {
        for (node in array[hash(key)]) {
            if (node.key == key) return node.value
        }
        return null
    }

    override fun put(key: Int, value: String) {
        val bucket = array[hash(key)]
        for (i in 0..bucket.lastIndex) {
            if (bucket[i].key == key) {
                bucket[i] = DictionaryNode(key, value)
                return
            }
        }
        bucket.add(DictionaryNode(key, value))
        size++
    }

    private fun hash(key: Int): Int {
        return key % internalSize
    }
}

private data class DictionaryNode(
    val key: Int,
    val value: String,
)
