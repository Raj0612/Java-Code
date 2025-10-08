package DesignPatterns.Creational.FactoryMethod.Message;

public class TextMessage extends Message {
	
	@Override
	public String getContent() {
		return "Text";
	}
	
}
