package practice;

class MiscClass {

    private static int i = 0;

    public static void main(String[] args) {
        char[] arr = "Hannah".toCharArray();
        char[] arr2 = "Hello".toCharArray();
        reverseString(arr);

        for (char s: arr)  {
            System.out.println(s);
        }
    }

    public static void reverseString(char[] s) {
        if (i >= s.length / 2) return;
        char temp = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = temp;
        i++;
        reverseString(s);
    }
}