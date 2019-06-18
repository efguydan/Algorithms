package LeapFrogCh2;

public class Main {

    public static void main(String[] args) {
        String[] inputs = {"leapfrog_ch__sample_input", "leapfrog_ch_"};
        for (String in : inputs) {
            LeapfrogChTwo leapfrogChOne = new LeapfrogChTwo();
            String filepath = "/Users/efedaniel/IdeaProjects/FacebookHackerCup/src/LeapfrogCh2/";
            leapfrogChOne.parseInput(filepath + in + ".txt");
            leapfrogChOne.simulate();
            leapfrogChOne.printOutput(filepath + in + "_output.txt");
        }
    }
}
