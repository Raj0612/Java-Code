package DesignPatterns.Behavioral.Interpreter.Permission;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
