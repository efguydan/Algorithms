package practice.hashcode.qualification2019;

import practice.hashcode.qualification2019.model.Photo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private ArrayList<Photo> inputList = new ArrayList<>();
    private ArrayList<String> slideShow = new ArrayList<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            int T = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < T; i++) {
                String line = bufferedReader.readLine();
                String[] arr = line.split(" ");
                List<String> tags = new ArrayList<>();
                for (int j = 2; j < Integer.parseInt(arr[1]) + 2; j++) tags.add(arr[j]);
                inputList.add(new Photo(i, arr[0].charAt(0), tags));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        for (Photo photo : inputList) {
            slideShow.add(solve(photo));
        }
    }

    public String solve(Photo input) {
        return input.toString();
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            for (int j = 0; j < slideShow.size(); j++) {
                writer.print(slideShow.get(j));
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
