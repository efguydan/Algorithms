package com.efedaniel.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.lang.*;

/**
 * 
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/non-divisible-subset/problem
 * Progress: Done
 *
 */

public class NonDivisibleSubset {
	public static void main (String [] args) {
		
		int [] array = {1, 7, 2, 4};
        System.out.println(nonDivisibleSubset(3, array));
        
        int [] array2 = {278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436};
        System.out.println(nonDivisibleSubset(7, array2));
        
        int [] array3 = {1, 2, 3, 4, 5};
        System.out.println(nonDivisibleSubset(1, array3));
        
        int [] array4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(nonDivisibleSubset(4, array4));
	}
	
	static int nonDivisibleSubset(int k, int[] S) {
		
		if((k == 1) || (S.length == 1))
			return 1;
		
		int temp;
		int[] modArray = new int[k];
        
        for(int i=0; i<S.length; i++){
        	temp = S[i]%k;
        	modArray[temp]++;
        }
       
        int max = 0;
        int endOfLoop;
        
        if(k/2 != 0)
        	endOfLoop =  (int) k/2 + 1;
        else
        	endOfLoop =  (int) k/2;
        
        for (int i = 1; i < endOfLoop; i++) {
        	if(i == k-i) {
        		if(modArray[i] > 0)
        			max++;
        		continue;
        	}else {
	        	if(modArray[i] >= modArray[k-i])
	        		max+= modArray[i];
	        	else
	        		max+= modArray[k-i];
        	}
        }
        
        if(modArray[0] > 0)
        	max++;
        
		return max ;
        
	}
}
