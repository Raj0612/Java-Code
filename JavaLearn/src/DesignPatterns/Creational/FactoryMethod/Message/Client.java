package DesignPatterns.Creational.FactoryMethod.Message;


public class Client {

	public static void main(String[] args) {
	//	printMessage(new JSONMessageCreator());
		
	//	printMessage(new TextMessageCreator());

		MessageCreator jsonMsgCreator = new JSONMessageCreator();
		Message jsonMessage = jsonMsgCreator.getMessage();
		System.out.println("jsonMessage " + jsonMessage);

		MessageCreator textMsgCreator = new TextMessageCreator();
		Message textMessage = textMsgCreator.getMessage();
		System.out.println("textMessage " + textMessage);
	}
	
	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
}
