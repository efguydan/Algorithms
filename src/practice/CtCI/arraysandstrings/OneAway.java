package practice.CtCI.arraysandstrings;

/**
 *  @author EfeDaniel
 * Link: Ctci Page 91, 1.5
 * Progress: Passed all tried testcases yet
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("bale", "bale"));
        System.out.println(oneAway("pale", "bake"));
    }


    // Solution 1
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean oneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        int[] charFounds1 = new int[128];
        int[] charFounds2 = new int[128];

        for (char c : s1.toCharArray()) charFounds1[c]++;
        for (char c : s2.toCharArray()) charFounds2[c]++;

        boolean oddFound = false;

        for (int i = 0; i < charFounds1.length; i++) {
            int diff = Math.abs(charFounds1[i] - charFounds2[i]);
            if (diff == 0) continue;
            else if (diff == 1) {
                if (!oddFound) oddFound = true; else return false;
            } else return false;
        }

        return true;
    }

}
