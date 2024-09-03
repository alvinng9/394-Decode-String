package org.example;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        //create a stack of characters
        Stack<Character> stack = new Stack<>();
        //iterate through the String
        for (int i = 0; i < s.length(); i++) {
            //add all characters that aren't]' to the stack
            if (s.charAt(i) != ']') {
                stack.add(s.charAt(i));
            } else {
                //build a string with characters up to before the character '['
                //in the stack
                StringBuilder sb = new StringBuilder();
                while(!stack.empty() && stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                String stringTemp = sb.toString();
                sb = new StringBuilder();
                //build an integer with all the numbers before a letter appears in
                //the stack
                while(!stack.empty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());
                //after we find the frequency and the string
                //add that number of times of the characters in the string
                //just found back to the stack
                for (int j = 1; j <= count; j++) {
                    for (int k = 0; k < stringTemp.length(); k++) {
                        stack.add(stringTemp.charAt(k));
                    }
                }
            }
        }
        //create a string builder to return the result
        StringBuilder result = new StringBuilder();
        //add characters in the stack until the stack is empty
        while(!stack.empty()) {
            result.append(stack.pop());
        }
        //reverse the string builder
        return result.reverse().toString();
    }
}
