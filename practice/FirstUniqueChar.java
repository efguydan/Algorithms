package practice;

public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("racecars"));
    }

//    public static String firstUniqueChar(String string) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < string.length(); i++) {
//            char currentChar = string.charAt(i);
//            if (map.containsKey(currentChar)) {
//                map.put(currentChar, map.get(currentChar) + 1);
//            } else {
//                map.put(currentChar, 1);
//            }
//        }
//        for (int i = 0; i < string.length(); i ++) {
//            if (map.get(string.charAt(i)) == 1) return String.valueOf(string.charAt(i));
//        }
//        return "";
//    }

    public static String firstUniqueChar(String string) {
        //remove all spaces
        string = string.replaceAll("\\s+", "").toLowerCase();
        //convert string to all lower case
        int prevLength = string.length();
        while(prevLength > 0) {
            String currentChar = String.valueOf(string.charAt(0));
            string = string.replace(currentChar, "");
            int newLength = string.length();
            if (prevLength - newLength == 1) {
                return currentChar;
            }
            prevLength = newLength;
        }
        return "";
    }

}
