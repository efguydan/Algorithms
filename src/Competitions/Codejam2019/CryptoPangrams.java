import java.math.BigInteger;
import java.util.*;

public class CryptoPangrams {

    public static void cryptoPangrams() {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int largestPrime = input.nextInt();
            int noOfInput = input.nextInt();
            BigInteger[] numberArray  = new BigInteger[noOfInput];
            for (int i = 0; i < noOfInput; i++) {
                numberArray[i] = input.nextBigInteger();
            }
            System.out.println(String.format("Case #%d: %s", ks, solve(largestPrime, numberArray)));
        }
    }

    private static String solve(int largestPrime, BigInteger[] numberArray) {
        StringBuilder answer = new StringBuilder();
        Set<BigInteger> primeSet = new TreeSet<>();
        HashMap<BigInteger, BigInteger> numberListWithPrimes= new HashMap<>();
        BigInteger firstprime = getGCD(numberArray[0], numberArray[1]);
        primeSet.add(firstprime);
        primeSet.add(numberArray[0].divide(firstprime));
        numberListWithPrimes.put(numberArray[0], firstprime);
        BigInteger lastCommonPrime = firstprime;
        for (int i = 1; i < numberArray.length; i++) {
            primeSet.add(numberArray[i].divide(lastCommonPrime));
            lastCommonPrime = numberArray[i].divide(lastCommonPrime);
            numberListWithPrimes.put(numberArray[i], lastCommonPrime);
        }
        primeSet.add(numberArray[numberArray.length - 1].divide(numberListWithPrimes.get(numberArray[numberArray.length -1])));
        HashMap<BigInteger, String> numberToChar = mapCharacterToNumber(primeSet.toArray(new BigInteger[primeSet.size()]));
        answer.append(numberToChar.get(numberArray[0].divide(numberListWithPrimes.get(numberArray[0]))));
        for (int i = 0; i < numberArray.length; i++) {
            answer.append(numberToChar.get(numberListWithPrimes.get(numberArray[i])));
        }
        return answer.toString();
    }

    public static BigInteger getGCD(BigInteger firstNum, BigInteger secondNum) {
        BigInteger largerNumber = firstNum.compareTo(secondNum) == 1 ? firstNum : secondNum;
        BigInteger smallerNumber = firstNum.compareTo(secondNum) == 1 ? secondNum : firstNum;
        while (smallerNumber.compareTo(new BigInteger("0")) == 1) {
            BigInteger temp = smallerNumber;
            smallerNumber = largerNumber.mod(smallerNumber);
            largerNumber = temp;
        }
        return largerNumber;
    }

    public static HashMap<BigInteger, String> mapCharacterToNumber(BigInteger[] primeNumbers) {
        HashMap<BigInteger, String> letterIndexMap = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 26; i++) {
            letterIndexMap.put(primeNumbers[i], String.valueOf(alphabet.charAt(i)));
        }
        return letterIndexMap;
    }
}
