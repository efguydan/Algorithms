package practice.cousera.linkedstackofstrings;

public class Main {
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        stack.push("be");
        stack.pop();

        stack.printItems();
    }
}
