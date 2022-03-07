package competitions.Hashcode2020;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"a_example", "b_read_on", "c_incunabula", "d_tough_choices", "e_so_many_books", "f_libraries_of_the_world"};
//        String[] inputs = {"c_incunabula"};

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/Competitions/Hashcode2020/input/";
            solutionClass.parseInput(filepath + in + ".txt");
            solutionClass.simulate();
            solutionClass.parseOutput(filepath + in + "_output.txt");
        }
    }
}
