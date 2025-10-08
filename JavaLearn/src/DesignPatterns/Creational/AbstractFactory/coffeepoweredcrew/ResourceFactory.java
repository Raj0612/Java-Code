package DesignPatterns.Creational.AbstractFactory.coffeepoweredcrew;

//Abstract factory with methods defined for each object type.

//The Abstract Factory Pattern  provides an interface for creating families of related or dependent objects without specifying their concrete classes and implementation,
// in simpler terms the Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.
public interface ResourceFactory {

	Instance createInstance(Instance.Capacity capacity);
	
	Storage createStorage(int capMib);
}
