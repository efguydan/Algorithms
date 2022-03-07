package competitions.IeeeXtreme2019;

import java.util.*;

public class LexicalAddition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double number = in.nextDouble();
        Double a = in.nextDouble();
        Double b = in.nextDouble();
        solve(number, a, b);
    }

    private static void solve(Double number, Double a, Double b) {
        if (a > number / 2) {
            System.out.println("NO");
            return;
        }
        Double minTimes = Math.floor(number /  b);
        Double maxTimes = Math.ceil(number / a);
        for (Double i = minTimes; i <= maxTimes; i++) {
            Double min = a * i, max = b * i;
            if (min <= number && max >= number) {
                //Answer is within this range. Use this i for solution
                getAnswer(number, a, b, i);
                return;
            }
        }
        System.out.println("NO");
    }

    private static void getAnswer(Double number, Double a, Double b, Double times) {
        Double[] answerArray = new Double[times.intValue()];
        Double sum = 0.0, diff = b - a;
        for (int i = 0; i < times; i++) {
            answerArray[i] = b;
            sum += b;
        }
        Double rem = sum - number;
        int index = 0;
        while (rem > 0) {
            if (rem > diff) {
                answerArray[index] = a;
                rem -= diff;
            } else {
                answerArray[index] -= rem;
                break;
            }
            index++;
        }
        System.out.println("YES");
        for (int k = 0; k < answerArray.length; k++) {
            if (k == 0) System.out.print(getIntValue(answerArray[k]));
            else System.out.print(" " + getIntValue(answerArray[k]));
        }
    }

    private static String getIntValue(Double num) {
        String s = num.toString();
        int indexOfDecimal = s.indexOf(".");
        return s.substring(0, indexOfDecimal);
    }
}
