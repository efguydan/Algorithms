package miniProjects.wordleStartingWords

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Solution {

    private val inputList = mutableListOf<String>()
    val characterMap = mutableMapOf<Char, Int>()
    private val outputList = mutableListOf<String>()

    fun parseInput(fileName: String) {
        try {
            val reader = File(fileName).bufferedReader()

            // Read each line
            for (line in reader.readLines()) {
                inputList.add(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun simulate() {
        for (word in inputList) {
            for (char in word) characterMap[char] = (characterMap[char] ?: 0) + 1
        }
        val mapReversed = characterMap.entries.associateBy({it.value}) { it.key }
        val values = mapReversed.keys.sortedDescending()

        for (value in values) {
            println(mapReversed[value])
        }
    }

    fun parseOutput(fileName: String) {
        try {
            val writer = File(fileName).printWriter()

            for (line in outputList) {
                writer.println(line)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

}