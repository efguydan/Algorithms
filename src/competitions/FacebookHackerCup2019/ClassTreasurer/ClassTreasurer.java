package competitions.FacebookHackerCup2019.ClassTreasurer;

import java.io.*;
import java.util.ArrayList;

public class ClassTreasurer {

    ArrayList<String> answerList = new ArrayList<>();

    public void parseInputAndSimulate(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
            int T = Integer.valueOf(bufferedReader.readLine());
            for (int i = 1; i <= T; i++) {
                String line = bufferedReader.readLine();
                String[] lineArray = line.split(" ");
                int numberOfStudents = Integer.valueOf(lineArray[0]);
                int threshold = Integer.valueOf(lineArray[1]);
                String pattern = bufferedReader.readLine();
                answerList.add(String.format("Case #%d: %d", i, solve(numberOfStudents, threshold, pattern)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int solve(int numberOfStudents, int threshold, String pattern) {
        long answer = 0L;
        int index = 0, noOfContinousB = 0;
        while(index < numberOfStudents) {
            if (pattern.charAt(index) == 'B') noOfContinousB++;
            else noOfContinousB = 0;
            if (noOfContinousB > threshold) {
                int noOfBinFront = getNumberOfBinFront(pattern, index, threshold);
                answer = computeSum(answer, index - threshold + noOfBinFront + 1);
                noOfContinousB = 0;
                index += noOfBinFront;
            }
            index++;
        }
        return (int) answer;
    }

    private int getNumberOfBinFront(String pattern, int index, int threshold) {
        int answer = 0;
        for (int i = 1; i < threshold; i++) {
            if (index + i < pattern.length() && pattern.charAt(index + i) == 'B') answer++;
            else break;
        }
        return answer;
    }

    public static long computeSum(long currentAnswer, int n) {
        long m = 1000000007L;
        long answer = (currentAnswer % m) + (long) (Math.pow(2, n) % m);
        return answer % m;
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            for (int j = 0; j < answerList.size(); j++) {
                writer.print(answerList.get(j));
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
