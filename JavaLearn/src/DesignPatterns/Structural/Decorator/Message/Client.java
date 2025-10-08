package DesignPatterns.Structural.Decorator.Message;

public class Client {

	public static void main(String[] args) {
		Message m = new TextMessage("The <FORCE> is strong with this one!");
		System.out.println(m.getContent());

		Message htmlEncodedDecorator = new HtmlEncodedMessage(m);
		System.out.println(htmlEncodedDecorator.getContent());

		Message base64EncodedDecorator  = new Base64EncodedMessage(htmlEncodedDecorator);
		System.out.println(base64EncodedDecorator.getContent());
	}
}
