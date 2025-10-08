package DesignPatterns.Behavioral.Interpreter.Permission;

public class Client {

	public static void main(String[] args) {
		Report report1  = new Report("Cashflow repot", "FINANCE_ADMIN OR ADMIN");
		ExpressionBuilder builder = new ExpressionBuilder();
		
		PermissionExpression  exp = builder.build(report1);
		System.out.println("exp " + exp);
		
		User user1 = new User("Dave", "USER");
		User user2 = new User("DaveJohn", "ADMIN");

		User user3 = new User("DaveJohnBay", "USER", "TESTER");
		
		System.out.println("USer access report:"+ exp.interpret(user1));
		System.out.println("USer access report1:"+ exp.interpret(user2));
		System.out.println("USer access report3:"+ exp.interpret(user3));
	}

}
