package DesignPatterns.Behavioral.Interpreter.upgrad;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        String tokenString ="7 3 - 2 1 + *";
        Stack<Expression> stack = new Stack<>();
        String[] tokenArray = tokenString.split(" ");
        for(String token: tokenArray){
            if(ExpressionUtils.isOperator(token)){
                Expression right = stack.pop();
                Expression left = stack.pop();
                Expression operator = ExpressionUtils.getOperator(token, left, right);
                int result = operator.interpret();
                stack.push(new Number(result));

            }else{
                Expression num = new Number(Integer.parseInt(token));
                stack.push(num);
            }

        }
        System.out.println("(" + tokenString + "): " + stack.pop().interpret());
    }
}
