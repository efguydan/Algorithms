import java.util.ArrayList;

/**
 * 
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * Progress: Done
 *
 */

public class ValidPreorderSerialization {

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") == true);
		System.out.println(isValidSerialization("1,#,#,#,#") == false);
		System.out.println(isValidSerialization("1") == false);
	}
	
	public static boolean isValidSerialization(String preorder) {
        String[] arrayList = preorder.split(",");
        int[] openNodes = new int[arrayList.length];
        int currentIndexOfOpenNodes = 0;
        int i=0;
        String hash = "#";
        
        if(arrayList[0].equals(hash) && arrayList.length == 1)
        	return true;
        
        if(arrayList[0].equals(hash))
        	return false;
        
        for(i=0; i<arrayList.length; i++) {
        	if(!arrayList[i].equals(hash)) {
        		if(openNodes[currentIndexOfOpenNodes] < 2) {
	        		openNodes[currentIndexOfOpenNodes]++;
	    			currentIndexOfOpenNodes++;
        		}else {
        			currentIndexOfOpenNodes++;
        			openNodes[currentIndexOfOpenNodes]++;
	    			currentIndexOfOpenNodes++;
        		}
        	}else {
        		if(!arrayList[i-1].equals(hash)) {
        			currentIndexOfOpenNodes--;
        		}
        		if(openNodes[currentIndexOfOpenNodes]==0) {
        			openNodes[currentIndexOfOpenNodes]++;
        		}else if(openNodes[currentIndexOfOpenNodes]==1) {
        			openNodes[currentIndexOfOpenNodes]++;
        		}else {
        			openNodes[currentIndexOfOpenNodes]++;
        			while(openNodes[currentIndexOfOpenNodes] == 3) {
        				openNodes[currentIndexOfOpenNodes] = 0;
        				if(currentIndexOfOpenNodes == 0)
        					break;
        				openNodes[currentIndexOfOpenNodes-1]++;
        				currentIndexOfOpenNodes--;
        			}
        		}
        	}
        	if(currentIndexOfOpenNodes == 0 && openNodes[0] == 0)
				break;
        }
        
        if(i!=arrayList.length - 1)
        	return false;
        if(openNodes[0] == 0)
        	return true;
        return false;
    }

}
