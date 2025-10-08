package DesignPatterns.Creational.FactoryMethod.Message;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		System.out.println("TextMessageCreator:createMessage");
		return new TextMessage();
	}



}
