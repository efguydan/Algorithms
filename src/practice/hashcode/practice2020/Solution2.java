package practice.hashcode.practice2020;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {

    private ArrayList<Integer> inputList = new ArrayList<>();
    private ArrayList<Integer> outPutList = new ArrayList<>();
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap();
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
                placeValueInMap(current, i);
            } else {
                int threshold = currentSum + current - maxSlice;
                for (int k = threshold; k < current; k++) {
                    if (map.containsKey(k)) {
                        ArrayList<Integer> list = map.get(k);
                        int toRemove = list.remove(0);
                        currentSum += current;
                        currentSum -= k;
                        outPutList.remove(outPutList.indexOf(toRemove));
                        outPutList.add(i);
                        placeValueInMap(current, i);
                        if (list.isEmpty())
                            map.remove(k);
                        else
                            map.put(current, list);
                        break;
                    }
                }
            }
            if (currentSum == maxSlice) break;
        }
        System.out.println(currentSum);
    }

    private void placeValueInMap(int current, int i) {
        ArrayList<Integer> list;
        if (map.containsKey(current)) {
            list = map.get(current);
        } else {
            list = new ArrayList<>();
        }
        list.add(i);
        map.put(current, list);
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
