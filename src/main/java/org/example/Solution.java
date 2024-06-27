package org.example;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                String sub = sb.toString();
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < sub.length(); j++) {
                        stack.push(sub.charAt(j));
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
