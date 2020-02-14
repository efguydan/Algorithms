package practice.hashcode.practice2020;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {

    private ArrayList<Integer> inputList = new ArrayList<>();
    private ArrayList<Integer> outPutList = new ArrayList<>();
    private HashMap<Integer, ArrayList<Integer>> used = new HashMap();
    private int maxSlice;
    private int currentSum;

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            String[] arr = bufferedReader.readLine().split(" ");
            maxSlice = Integer.parseInt(arr[0]);
            int T = Integer.parseInt(arr[1]);
            currentSum = 0;

            String l = bufferedReader.readLine();
            String[] lArr = l.split(" ");

            for (int i = 0; i < T; i++) {
                System.out.println("Getting input: " + i);
                inputList.add(Integer.valueOf(lArr[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        for (int i = 0; i < inputList.size(); i++) {
            int current = inputList.get(i);
            if (currentSum + current <= maxSlice) {
                outPutList.add(i);
                currentSum += current;
            } else {
                //TODO Try to remove the blocker
            }
            if (currentSum == maxSlice) break;
        }
        System.out.println(currentSum);
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println(outPutList.size());
            for (int j = 0; j < outPutList.size(); j++) {
                writer.print(outPutList.get(j));
                writer.print(" ");
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
