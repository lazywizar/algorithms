package com.thinklazy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TestClass {
	public static int MAX = 100000;
	
	public static void main(String args[]) {
		int[] coins = {1, 3, 5};
		System.out.println(knapSack(coins,8));
		
		Test t = Test.getTestInstance();
		
		//System.out.println(swapBits(4, 1, 3));
		//reverse("abcdef");
		//System.out.println(reverseWithReturn("abcdef"));
		//System.out.println(countWords("hello    mr     anderson"));
		//reverseWordOfSentence("hello    mr     anderson");
		//permute("aab".toCharArray(), 0);
		//System.out.println(isBitSet(3, 2));
		//System.out.println(isBitSet(4, 0));
		//subSets("abc".toCharArray());
		//printAllSetBitsFromArray("abc".toCharArray(), 3);
		//char[] a = new char[10];
		//backTracking(a, 0, "abc".toCharArray());
		/**int[] a = new int[]{4, 5, 1, 6, 3};
		quickSort(a, 0, 4);
		for(int i = 0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}**/
		
	}
	
	//Should return the min number of coins required to get to the sum.
	public static int knapSack(int coins[], int sum) {
		int result[] =  new int[sum+1];
		Arrays.fill(result, MAX);
		//Base condition
		result[0] = 0;
		
		//Construct bottom up
		for(int i = 1; i <= sum ; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i) {
					result[i] = min(knapSack(coins, i-coins[j]) + 1, result[i]);
				}
			}
		}
		return result[sum];
	}
	
	public static int[] longestDecreasingSequence(int[] a) {
	 return null;	
	}
	
	public static int min(int a, int b) {
		if(a < b) 
			return a;
		else 
			return b;
	}
	
    public static void quickSort(int[] a, int low, int high)
    {
        if(low<high)
        {
            int pivotPoint = partition(a,low,high);
            quickSort(a,low,pivotPoint);
            quickSort(a,pivotPoint+1,high);
        }
    }

    private static int partition(int[] a, int p, int q) {
        int pivot = a[p];
        int i = p ;
        int j = q ;

        while (true) {
   
            while ( a[i] < pivot)
                i++;
            
            while ( a[j] > pivot)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
            
            i++; j--;
        }
    }
	
	/**
	 * a is array
	 * K is the index till where the conditions are satisfied
	 * @param a
	 * @param k
	 */
	public static void backTracking(char[]a, int k, char[] org) {
		if(isASolution(org, k)) {
			processSolution(a, org);
		} else {
			char[] c = generateCandidates(a, k);
			k++;
			for(int i = 0; i< c.length; i++) {
				a[k] = c[i];
				backTracking(a, k, org);
			}
		}
	}
	
	private static boolean isASolution(char[] a, int k) {
		if(k > a.length) {
			return true;
		}
		return false;
	}
	
	private static void processSolution(char[] a, char[] org) {
		System.out.print("{");
		for(int i = 0; i <org.length; i++) {
			if(a[i] == 1) {
				System.out.print(org[i]);
			}
		}
		System.out.print("} ");
	}
	
	private static char[] generateCandidates(char[] a, int k) {
		char[] c = {0, 1};
		return c;
	}
	
	public static void subSets(char[] a) {
		int n = a.length;
		//There are two options for all elements present or not present
		// 2^n solutions including empty set
		
		//To represent this we can utilize the binary representation of a integer
		//Another observation :
		// {abc} 
		// 001 => {a}, .... ,111 => {abc} this is the largest number so we can stop here
		for(int i =0 ; ;i++) {
			if(printAllSetBitsFromArray(a, i) == a.length) {
				break;
			}
		}		
	}
	
	public static int printAllSetBitsFromArray(char[] a, int num) {
		int bitIndex = a.length-1;
		int count = 0;
		
		while(bitIndex >= 0) {
			if((num & (1L << bitIndex)) != 0) {
				System.out.print(a[bitIndex]);
				count++;
			}
			bitIndex--;
		}
		System.out.println();
		return count;
	}
	
	public static boolean isBitSet(int num, int bitIndex) {
		return ((num & (1 << bitIndex)) > 0);
	}
	
	Map<String, Boolean> map = new HashMap<String, Boolean>();
	
	
	public static void permute(int[] a, int k) {
		if(k == a.length -1) {
			System.out.println(a);
			return;
		}
		for (int i = k; i < a.length; i++) {
		          swap(a, i, k);          
		          permute(a, k+1);
		          swap(a,i ,k);		       
		}
	}
	
	public static void swap(int[] a, int i, int j){
		int temp =  a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void reverseWordOfSentence(String sent) {
		int i = 0; int j = 0 ;
		
		while(j < sent.length()) {
			if(sent.charAt(j) == ' ') {
				//found a word from i to j
				
				
				reverse(sent.substring(i, j));
				System.out.print(" ");
				i = j+1;
				//skip multiple spaces
				while(sent.charAt(i) == ' ') {
					i++;
				}
				j = i;
			} else {
				j++;
			}
		}
		reverse(sent.substring(i, j));
	}
	
	
	
	public static void reverse(String s) {
		if(s.length() == 0) {
			return;
		}
		reverse(s.substring(1));
		System.out.print(s.charAt(0));
	}
	
	public static String reverseWithReturn(String s) {
		if(s.length() == 0) {
			return "";
		}
		char c = s.charAt(0);
		return reverseWithReturn(s.substring(1)) + c ;
	}
	
	
	public static int countWords(String s) {
		char[] c = s.toCharArray();
		int count = 0; 
		boolean inWord = false;
		for(int i = 0;i < s.length(); i++) {
			if(c[i] != ' ') {
				if(!inWord) {
					inWord = true;
					count++;
				}
			} else {
				inWord = false;
			}
		}
		return count;
	}
	
	public static boolean isBitPalin(int n){
		int l = 0;
		int len = 0;
		int x = n;
		while(x > 0) {
			x = x >> 1;
			len++;
		}
		
		while(l <= len/2 +1){
			long ai = 1L << l;
			long bi = 1L << (len-1-l);
			long a = (n & ai);
			long b = n & bi;
			
			//if((n & (1L << l)) ^ (n & (1L << len -1 -l))) {
			//	return false;
			//}
			l++;
		}
		return true;
	}
	
	public int reverseBits(int n) {
		int s = 0; int e = 0;
		int x = n;
		while(x > 0) {
			x = x >> 1;
			e++;
		}
		
		while(s < e) {
			//if()
		}
		return 0;
	}
	
	public static int swapBits(int x, int i, int j) {
		  int lo = ((x >> i) & 1);
		  int hi = ((x >> j-1) & 1);
		  if ((lo ^ hi) > 0) {
		    x ^= ((1L << i) | (1L << j));
		  }
		  return x;
	}
}
