package DesignPatterns.Creational.Singleton.CoffeePowderedCrew;

public class Client {

	public static void main(String[] args) {

		EagerRegistry eagerRegistry = EagerRegistry.getInstance();
		EagerRegistry eagerRegistry1 = EagerRegistry.getInstance();
		System.out.println(eagerRegistry == eagerRegistry1);

		LazyRegistryWithDCL lazyRegistryWithDCL = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL lazyRegistryWithDCL1 = LazyRegistryWithDCL.getInstance();
		System.out.println(lazyRegistryWithDCL == lazyRegistryWithDCL1);

		LazyRegistryIODH singleton;
		singleton = LazyRegistryIODH.getInstance();
		LazyRegistryIODH singleton2 = LazyRegistryIODH.getInstance();
		System.out.println(singleton == singleton2);

		RegistryEnum instance = RegistryEnum.INSTANCE;
		instance.someMethod();
	}

}
