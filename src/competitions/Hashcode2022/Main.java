package competitions.Hashcode2022;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {
//                "a_an_example.in",
                "b_better_start_small.in",
                "c_collaboration.in",
                "d_dense_schedule.in",
//                "e_exceptional_skills.in",
//                "f_find_great_mentors.in"
        };

        for (String in : inputs) {
            Solution solutionClass = new Solution();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/competitions/Hashcode2022/tests/";
            solutionClass.parseInput(filepath + in + ".txt");
            for (int i = 0; i < 20; i++) {
                solutionClass.simulate();
            }
            solutionClass.parseOutput(filepath + in + "_out.txt");
        }
    }
}
