package practice.hashcode.practice2020;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"a_example", "b_small", "c_medium", "d_quite_big", "e_also_big"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/practice/hashcode/practice2020/tests/";
            solutionClass.parseInput(filepath + in + ".in");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
