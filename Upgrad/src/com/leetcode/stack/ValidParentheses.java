package com.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
/*
An input string is valid if:
1) Open brackets must be closed by the same type of brackets.
2) Open brackets must be closed in the correct order.
3) Every close bracket has a corresponding open bracket of the same type.
 */

/*
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String str = "";
        str= "()[]{}";
        str= "(]";
        str= "{}[)(]";
        str= "{}({[]}))(]";
        str= "({[]})";

        System.out.println("isValidBySwitchCase " + isValidBySwitchCase(str));
        System.out.println("isValid " + isValid(str));
        System.out.println("isValid1 " + isValid1(str));

    }

    static boolean isValidBySwitchCase(String str) {
        Stack<Character> bracket = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    bracket.push(c);
                    break;
                case '{':
                    bracket.push(c);
                    break;
                case '[':
                    bracket.push(c);
                    break;
                case ')':
                    if (bracket.empty() || bracket.peek()!='(')
                        return false;
                    else
                        bracket.pop();
                    break;
                case '}':
                    if (bracket.empty() || bracket.peek()!='{')
                        return false;
                    else
                        bracket.pop();
                    break;
                case ']':
                    if (bracket.empty() || bracket.peek()!='[')
                        return false;
                    else
                        bracket.pop();
                    break;
                default: ;
            }
        }
        return bracket.isEmpty();
    }

    public static boolean isValid(String s) {
        HashMap map = new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(map.get(stack.pop()).equals(c)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //Time-O(n) Space-O(n)
    public static boolean isValid1(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        if(length==0)
            return true;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<length;i++){
            if(charArray[i]=='(' || charArray[i]=='[' || charArray[i]=='{'){
                stack.push(charArray[i]);
            } else if(!stack.empty() && charArray[i]==')' && stack.peek()=='('){
                stack.pop();
            } else if(!stack.empty() && charArray[i]==']' && stack.peek()=='['){
                stack.pop();
            } else if(!stack.empty() && charArray[i]=='}' && stack.peek()=='{'){
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
