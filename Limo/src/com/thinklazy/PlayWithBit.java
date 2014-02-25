package com.thinklazy;

public class PlayWithBit {
	public static void main(String args[]) {
		int val = 9;
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(reverse(val)));
		
		System.out.println(isPal(val));
		
		
		//System.out.println(Integer.toBinaryString(swapBits(val,1,3)));
        
		/*
		System.out.println(Integer.toBinaryString(getMaskForKBits(countBits(val),1)));
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(revertAllBits(val)));
        System.out.println(Integer.toBinaryString(14));
		for(int i = 0; i < 5; i++) {
			System.out.println("Bit " + i + " : " + isBitSet(14, i));
		}*/
	}
	
	public static boolean isPal(int orig) {
		int copy = orig;
		int reversed = 0;

		while (copy != 0) {
			reversed <<= 1;
			reversed |= (copy & 1);
			copy >>>= 1;
		}
		return (reversed == orig);
	}
	
	public static int reverse(int num) {
		int reversed = 0;

		while (num != 0) {
			reversed <<= 1;
			reversed |= (num & 1);
			num >>>= 1;
		}
		return reversed;
	}
	
	
	public static int swapBits(int n, int i, int j) {
		int ithBit = (n>>i) & 1;
		int jthBit = (n>>j) & 1;
		
		int xorIJ = ithBit ^ jthBit;
		
		return n ^ ((xorIJ << i) | (xorIJ << j));
	}
	
	public static int swapBitsShort(int n, int i, int j) {
		int x = ((n >> i) ^ (n>>i)) & 1;
		return n ^ ((x << i) | (x << j));
	}
	
	public static int countBits(int n) {
		int count = 1;
		while((n >> 1) > 0) {
			count++;
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * k = 3, value = 1 => 111;
	 * k = 3, value = 0 => 000;
	 * 
	 * can also be done as n -1 :-)
	 * @param k
	 * @param value
	 */
	public static int getMaskForKBits(int k, int value) {
		while(k > 1) {
			value = value | value << 1;
			k--;
		}
		return value;
	}
	
	public static int getMaskForKBitsEffecient(int value) {
		int x = 1 << countBits(value);
		return x-1;
	}
	
	public static int revertAllBits(int val) {	
		return ~val & getMaskForKBits(countBits(val),1);
	}
	
	public static boolean isBitSet(int num, int k) {
		if(((num >> k) & 1) == 0) {
			return false;
		}
		return true;
	}
}
