package Competitions.IeeeXtreme2019;

import java.util.*;

public class PuzzleOfRooks {
    //Boolean to check if it is currently on board
    private static HashMap<String, Boolean> piecesInitial = new HashMap<>();
    //Boolean to check if the position has been filled
    private static HashMap<String, Boolean> piecesTarget = new HashMap<>();
    private static HashMap<String, Boolean> horizontalBoardState = new HashMap<>();
    private static HashMap<String, Boolean> verticalBoardState = new HashMap<>();
    private static ArrayList<String> listOfMoves = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String x = in.next();
            String y = in.next();
            piecesInitial.put(x+y, true);
            horizontalBoardState.put(x, true);
            verticalBoardState.put(y, true);
        }
        for (int i = 0; i < n; i++) {
            String x = in.next();
            String y = in.next();
            piecesTarget.put(x+y, piecesInitial.containsKey(x+y));
        }

    }
}
