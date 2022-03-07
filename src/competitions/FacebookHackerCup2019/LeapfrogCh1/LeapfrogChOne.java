package competitions.FacebookHackerCup2019.LeapfrogCh1;

import java.io.*;
import java.util.ArrayList;

public class LeapfrogChOne {

    ArrayList<String> questionList = new ArrayList<>();
    ArrayList<String> answerList = new ArrayList<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
            int T = Integer.valueOf(bufferedReader.readLine());
            for (int i = 0; i < T; i++) {
                String l = bufferedReader.readLine();
                questionList.add(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        for (int i = 0; i < questionList.size(); i++) {
            answerList.add(String.format("Case #%d: %s", i + 1, solve(questionList.get(i))));
        }
    }

    public String solve(String colonyPosition) {
        colonyPosition = colonyPosition.substring(1);
        int numberOfB = 0, numberOfDot = 0;
        if (colonyPosition.length() == 0) {
            return "Y";
        }
        for (int i = 0; i < colonyPosition.length(); i++) {
            switch (colonyPosition.charAt(i)) {
                case 'B':
                    numberOfB++;
                    break;
                case '.':
                    numberOfDot++;
                    break;
            }
        }
        if (numberOfB == 0 || numberOfDot == 0 || numberOfDot > numberOfB) {
            return "N";
        }
        return "Y";
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
