package DesignPatterns.Creational.Builder.UserDTOInner;

import DesignPatterns.Creational.Builder.User.Address;

import java.time.LocalDate;


public class Client {

	public static void main(String[] args) {
		DesignPatterns.Creational.Builder.User.User user = createUser();
		// Client has to provide director with concrete builder
		User dto = directBuild(User.getBuilder(), user);
		System.out.println(dto);
	}

	/**
	 * This method serves the role of director in builder pattern.
	 */
	private static User directBuild(User.UserBuilder builder, DesignPatterns.Creational.Builder.User.User user) {
		return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
				.withBirthday(user.getBirthday()).withAddress(user.getAddress()).build();
	}

	/**
	 * Returns a sample user.
	 */
	public static DesignPatterns.Creational.Builder.User.User createUser() {
		DesignPatterns.Creational.Builder.User.User user = new DesignPatterns.Creational.Builder.User.User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}

}
