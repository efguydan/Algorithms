package practice;

public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(reverseSentence("My name Is Efe"));
    }

    public static String reverseSentence(String sentence) {
        String[] wordArray = sentence.split(" ");
        for (int i = 0; i < wordArray.length; i++) wordArray[i] = reverseWord(wordArray[i]);
        return String.join(" ", wordArray);
    }

    private static String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
