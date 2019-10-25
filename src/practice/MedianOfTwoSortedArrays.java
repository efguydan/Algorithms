package practice;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 2, 4}, new int[] {3, 5}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, length = nums1.length + nums2.length;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                newArray[i+j] = nums1[i];
                i++;
            } else {
                newArray[i+j] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            newArray[i+j] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            newArray[i+j] = nums2[j];
            j++;
        }
        if (length % 2 == 0) {
            return (newArray[length/2] + newArray[length/2 - 1]) / 2.0;
        } else return newArray[length/2];
    }
}
