package com.thinklazy;

public class WildCardMatch {
	
	public static void main(String args[]){
//		System.out.println(match("g*ks", "geeks")); // Yes
	    match("ge?ks*", "geeksforgeeks"); // Yes
/*	    match("g*k", "gee");  // No because 'k' is not in second */
	    match("*pqrs", "pqrst"); // No because 't' is not in first
	    match("abc*bcd", "abcdhghgbcd"); // Yes
	    match("abc*c?d", "abcd"); // No because second must have 2 instances of 'c'
	    match("*c*d", "abcd"); // Yes
	    match("*?c*d", "abcd");
	}
	
	public static Boolean match(String regex, String str) {
	    // If we reach at the end of both strings, we are done
	    if (regex.isEmpty() && str.isEmpty()) {
	        return true;
	    }
	 
	    // Make sure that the characters after '*' are present in second string.
	    // This function assumes that the first string will not contain two
	    // consecutive '*' 
	    if (regex.charAt(0) == '*' && regex.length() != 1 && str.isEmpty()){
	        return false;
	    }
	    
	    // If the first string contains '?', or current characters of both 
	    // strings match
	    if (regex.charAt(0) == '?' || regex.charAt(0) == str.charAt(0)){
	        return match(regex.substring(1), str.substring(1));
	    }
	 
	    // If there is *, then there are two possibilities
	    // a) We consider current character of second string
	    // b) We ignore current character of second string.
	    if (regex.charAt(0) == '*'){
	        return match(regex.substring(1), str) || match(regex, str.substring(1));
	    }
	    return false;
	}
}
