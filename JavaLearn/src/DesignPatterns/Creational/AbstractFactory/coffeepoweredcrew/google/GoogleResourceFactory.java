package DesignPatterns.Creational.AbstractFactory.coffeepoweredcrew.google;


import DesignPatterns.Creational.AbstractFactory.coffeepoweredcrew.Instance;
import DesignPatterns.Creational.AbstractFactory.coffeepoweredcrew.ResourceFactory;
import DesignPatterns.Creational.AbstractFactory.coffeepoweredcrew.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Instance.Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
