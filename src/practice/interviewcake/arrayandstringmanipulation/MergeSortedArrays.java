package practice.interviewcake.arrayandstringmanipulation;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/merge-sorted-arrays?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class MergeSortedArrays {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {
        int[] answer = new int[myArray.length + alicesArray.length];

        int aliceIndex = 0;
        int myIndex = 0;
        int answerIndex = 0;

        while (aliceIndex < alicesArray.length) {
            if (myIndex < myArray.length && myArray[myIndex] < alicesArray[aliceIndex]) {
                answer[answerIndex] = myArray[myIndex];
                myIndex++;
            } else {
                answer[answerIndex] = alicesArray[aliceIndex];
                aliceIndex++;
            }
            answerIndex++;
        }

        while(myIndex < myArray.length) {
            answer[answerIndex] = myArray[myIndex];
            myIndex++;
            answerIndex++;
        }

        return answer;
    }

}
