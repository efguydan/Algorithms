package reusables.FileIOSkeletonKt

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        //TODO Add name of individual test files here
        val filepath = "Add your files path here"
        val inputs = listOf("name_of_file1", "name_of_file2")

        for (fileName in inputs) {
            val solution = Solution()
            solution.parseInput("$filepath$fileName.txt")
            solution.simulate()
            solution.parseOutput("$filepath${fileName}_out.txt")
        }

    }

}