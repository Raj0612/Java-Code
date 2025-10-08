package DesignPatterns.Structural.Facade.Email.email;

public class Email {

	public static EmailBuilder getBuilder() {
		return new EmailBuilder();
	}
}
