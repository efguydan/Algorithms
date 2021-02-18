package practice.hashcode.practice2021;

public class Main {
    public static void main(String[] args) {
        String[] exampleInput = {"a_example"};
        String[] inputs = {"a_example", "b_little_bit_of_everything", "c_many_ingredients", "d_many_pizzas", "e_many_teams"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/practice/hashcode/practice2021/tests/";
            solutionClass.parseInput(filepath + in + ".in");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
