package reusables.FileIOSkeleton;

public class Main {
    public static void main(String[] args) {
        //TODO Add name of individual test files here
        String[] inputs = {"name_of_file1", "name_of_file2"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "Add your files path here";
            solutionClass.parseInput(filepath + in + ".txt");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
