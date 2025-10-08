package DesignPatterns.Behavioral.Interpreter.upgrad;

public class Multiply implements Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Multiply(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() *  rightExpression.interpret();
    }
}
