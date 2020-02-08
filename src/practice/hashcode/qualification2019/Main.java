package practice.hashcode.qualification2019;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"a_example"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/practice/hashcode/qualification2019/inputs/";
            solutionClass.parseInput(filepath + in + ".txt");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
