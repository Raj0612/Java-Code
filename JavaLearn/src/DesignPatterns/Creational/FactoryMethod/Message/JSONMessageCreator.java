package DesignPatterns.Creational.FactoryMethod.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		System.out.println("JSONMessageCreator:createMessage");
		return new JSONMessage();
	}

	
}
