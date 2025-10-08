package DesignPatterns.Behavioral.Interpreter.upgrad;

public class ExpressionUtils {

    public static boolean isOperator(String s){
        return  s.equals("+") || s.equals("-") || s.equals("*") || s.equals("\\");
    }

    public static Expression getOperator(String s, Expression left, Expression right){

        if(s.equals("+"))
            return new Add(left, right);
        else if("-".equals(s))
            return new Subtract(left,right);
        else if("*".equals(s))
            return new Multiply(left,right);
        else
            return null;

    }
}
