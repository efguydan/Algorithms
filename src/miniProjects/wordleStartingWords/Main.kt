package miniProjects.wordleStartingWords

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/miniProjects/wordleStartingWords/"
        val inputs = listOf("sgb-words")

        for (fileName in inputs) {
            val solution = Solution()
            solution.parseInput("$filepath$fileName.txt")
            solution.simulate()
            solution.parseOutput("$filepath${fileName}_out.txt")
        }

    }

}