package com.designpattern;


import java.util.Stack;

interface Expression{
    int interpret();
}

class ExpressionUtils {
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static Expression getOperator(String s, Expression left, Expression right) {
        if (s.equals("+"))
            return new Add(left, right);
        else if (s.equals("-"))
            return new Subtract(left, right);
        else if (s.equals("*"))
            return new Multiply(left, right);
        else if (s.equals("/"))
            return new Divide(left, right);

        return  null;
    }
}
class  Number implements   Expression {
    private final int n;

    public Number(int n) {
        this.n = n;
    }

    @Override
    public int interpret() {
        return n;
    }
}
class Add implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    Add(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class Subtract implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    Subtract(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

class Multiply implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    Multiply(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}

class Divide implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;

    Divide(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() / rightExpression.interpret();
    }
}
public class InterpreterMain {
    public static void main(String[] args) {
        String tokenString = "7 3 - 2 1 + *";
        Stack<Expression> stack = new Stack<>();
        String[] tokenArray = tokenString.split(" ");
        for(String s: tokenArray){
            if(ExpressionUtils.isOperator(s)){
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = ExpressionUtils.getOperator(s, leftExpression, rightExpression);
                int result = operator.interpret();
                System.out.println("Result " + result);
                stack.push(new Number(result));
            }else{
                Expression i = new Number(Integer.parseInt(s));
                stack.push(i);
            }
        }

        System.out.println("Final Result " + stack.pop().interpret());
    }
}
