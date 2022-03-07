package competitions.FacebookHackerCup2019.ClassTreasurer;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"class_treasurer_sample_input"};
        for (String in : inputs) {
            ClassTreasurer classTreasurer = new ClassTreasurer();
            String filepath = "/Users/efedaniel/IdeaProjects/Algorithms/src/Competitions/FacebookHackerCup2019/ClassTreasurer/";
            classTreasurer.parseInputAndSimulate(filepath + in + ".txt");
            classTreasurer.parseOutput(filepath + in + "_output.txt");
        }
    }
}
