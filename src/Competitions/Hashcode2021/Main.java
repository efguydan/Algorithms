package Competitions.Hashcode2021;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"a", "b", "c", "d", "e", "f"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/Competitions/Hashcode2021/tests/";
            solutionClass.parseInput(filepath + in + ".txt");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
