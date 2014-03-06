package com.thinklazy;

public class BaseMagic {

    public static void main(String args[]) {
        System.out.println(1 + " : " + encode(1, 26));
        System.out.println(26 + " : " + encode(26, 26));
        System.out.println(27 + " : " + encode(27, 26));
        System.out.println(0 + " : " + encode(0, 26));
        System.out.println(25 + " : " + encode(25, 26));
        System.out.println(26100 + " : " + encode(26100, 26));
System.out.println();
        System.out.println(1 + " : " + decode("B", 26));
        
        System.out.println();
    }
    
    public static int decode(String s, int base) {
        int num = 0;
        int i = s.length() - 1;
        int exp = 0;
        while(i >= 0) {
            num = num + ((base^exp) * (s.charAt(i) - 'A'));
            i--;
            exp++;
        }
        return num;
    }
    
    public static String encode(int number, int base) {
        StringBuilder s = new StringBuilder();
        while(number > base-1) {
            int q = number/base;
            int r = number % base;
            
            s.append(Character.toChars('A' + r));
            number = q - 1;
        }
        s.append(Character.toChars('A' + number));
        return reverseWithReturn(s.toString());
        
    }
    
    public static String reverseWithReturn(String s) {
        if (s.length() == 0) {
            return "";
        }
        char c = s.charAt(0);
        return reverseWithReturn(s.substring(1)) + c;
    }

}
