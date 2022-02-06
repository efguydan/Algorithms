package practice

import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

object MiscKt {

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            solution(
                listOf(
                    listOf(1,2),
                    listOf(3,4),
                    listOf(1,-1)
                ),
                2
            )
        )
    }

    fun solution(locations: List<List<Int>> , n: Int): List<List<Int>> {
        var answer = mutableListOf<List<Int>>()
        val heap = PriorityQueue<Int>(Collections.reverseOrder())
        val map = mutableMapOf<Int, MutableList<List<Int>>>()

        for (location in locations) {
            val distance = computeDistance(location)

            if (heap.size < n) {
                addLocation(location, distance, heap, map)
                continue
            }

            val max = heap.peek()
            if (distance < max) {
                removeLocation(heap, map)
                addLocation(location, distance, heap, map)
            }
        }

        for (values in map.values) {
            answer.addAll(values)
        }

        return answer
    }

    private fun addLocation(
        location: List<Int>,
        distance: Int,
        heap: PriorityQueue<Int>,
        map: MutableMap<Int, MutableList<List<Int>>>
    ) {
        heap.add(distance)

        var current = map[distance]
        if (current == null) current = mutableListOf()
        current.add(location)
        map[distance] = current
    }

    private fun removeLocation(
        heap: PriorityQueue<Int>,
        map: MutableMap<Int, MutableList<List<Int>>>
    ) {
        val currentList = map[max]!!
        currentList.removeLast()

        if (currentList.isNotEmpty()) {
            map[max] = currentList
        } else {
            map.remove(max)
        }
        heap.remove()
    }

    private fun computeDistance(location: List<Int>) =
        (location.first().toDouble().pow(2) + location.last().toDouble().pow(2))
            .roundToInt()


}

