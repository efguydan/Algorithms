package reusables.FileIOSkeletonKt

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class Solution {

    private val inputList = mutableListOf<String>()
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