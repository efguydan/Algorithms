package competitions.IeeeXtreme2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Monokeros {

    private static ArrayList<Integer> answerList = new ArrayList<>();
    private static Node head = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfInputs = in.nextInt();
        for (int i = 0; i < noOfInputs; i++) {
            int newVal = in.nextInt();
            insertValue(head, newVal);
        }
        for (int i = 0; i < noOfInputs; i++) {
            if (i == 0) System.out.print(answerList.get(i));
            else System.out.print(" " + answerList.get(i));
        }
    }

    private static void insertValue(Node currentNode, int newValue) {
        if (currentNode == null) {
            Node newHead = new Node(newValue, 1);
            head = newHead;
            answerList.add(1);
            return;
        }
        if (newValue <= currentNode.value) {
            if (currentNode.left != null) {
                insertValue(currentNode.left, newValue);
            } else {
                Node newNode = new Node(newValue, currentNode.level + 1);
                currentNode.left = newNode;
                answerList.add(newNode.level);
            }
        } else {
            if (currentNode.right != null) {
                insertValue(currentNode.right, newValue);
            } else {
                Node newNode = new Node(newValue, currentNode.level + 1);
                currentNode.right = newNode;
                answerList.add(newNode.level);
            }
        }
    }

}

class Node {
    int value;
    int level;
    Node left;
    Node right;

    Node(int value, int level) {
        this.value = value;
        this.level = level;
        right = null;
        left = null;
    }
}
