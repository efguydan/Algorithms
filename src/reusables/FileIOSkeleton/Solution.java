package reusables.FileIOSkeleton;

import java.io.*;
import java.util.ArrayList;

public class Solution {

    //TODO Define input and output data structures here
    private ArrayList<String> inputList = new ArrayList<>();
    private ArrayList<String> outPutList = new ArrayList<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            //TODO Define how you collect each input here
            int T = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < T; i++) {
                String l = bufferedReader.readLine();
                inputList.add(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        for (int i = 0; i < inputList.size(); i++) {
            //TODO Add how you are gonna solve in here and add each output to output list.
            outPutList.add(solve(inputList.get(i)));
        }
    }

    public String solve(String input) {
        //TODO Solve for each input in here
        return "output";
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            for (int j = 0; j < outPutList.size(); j++) {
                writer.print(outPutList.get(j));
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
