import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RobotProgrammingStrategy {

    public static void robotProgrammingStrategy() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int noOfCompetitors = input.nextInt();
            ArrayList<String> competitingPrograms = new ArrayList<>();
            for (int i = 0; i < noOfCompetitors; i++) {
                competitingPrograms.add(input.next());
            }
            System.out.println(String.format("Case #%d: %s", ks, solve(noOfCompetitors, competitingPrograms)));
        }
    }

    private static String solve(int num, ArrayList<String> competitingPrograms) {
        StringBuilder answer = new StringBuilder();
        HashSet<String> gesturesFound = new HashSet<>();
        HashMap<String, ArrayList<String>> gesturesPosition = new HashMap<>();
        int currentIndex = 0;
        while (competitingPrograms.size() > 0) {
            int i = 0;
            for (String currentGesture : competitingPrograms) {
                ArrayList<String> tempArrayList;
                String currentGestureString = String.valueOf(currentGesture.charAt(currentIndex % currentGesture.length()));
                if (gesturesFound.add(currentGestureString)) {
                    tempArrayList = new ArrayList<>();
                } else {
                    tempArrayList = gesturesPosition.get(currentGestureString);
                }
                tempArrayList.add(competitingPrograms.get(i));
                gesturesPosition.put(currentGestureString, tempArrayList);
                i++;
            }
            String pickedGesture = "";
            if (gesturesFound.size() == 3) {
                return "IMPOSSIBLE";
            }
            for (String string : gesturesFound) {
                if (gesturesFound.contains(toDefeatCharacter(string)) || gesturesFound.size() == 1) {
                    pickedGesture = string;
                    break;
                }
            }
            answer.append(toDefeatCharacter(pickedGesture));
            competitingPrograms.removeAll(gesturesPosition.get(pickedGesture));
            gesturesFound.clear();
            gesturesPosition.clear();
            currentIndex++;
        }
        return answer.toString();
    }

    public static String toDefeatCharacter (String gesture) {
        if (gesture.equals("R")) {
            return "P";
        } else if (gesture.equals("P")) {
            return "S";
        } else {
            return "R";
        }
    }
}
