package learn.java8features.functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function< Integer, Double > centigradeToFahrenheitInt = x -> new Double((x * 9 / 5) + 32);

        Function < String, Integer > stringToInt = x -> Integer.valueOf(x);
        System.out.println(" String to Int: " + stringToInt.apply("4"));

        Function < PersonEntity, PersonDTO > function = (entity) -> {
            return new PersonDTO(entity.getName(), entity.getAge());
        };

        PersonDTO personDTO = function.apply(new PersonEntity("ramesh", 20));
        System.out.println(personDTO.getName());
        System.out.println(personDTO.getAge());

        //andThen default method
        Function<Integer, Double> half = a -> a / 2.0;
//        half = half.andThen(a -> 3 * a);
//        System.out.println(half.apply(10));
        System.out.println("andThen: " + half.andThen(a -> a *3).apply(10));

        //compose default method
        half = half.compose(a -> 3 * a);
        System.out.println("compose " + half.apply(10));
       // System.out.println("compose: " + (half.compose(a -> 3 * a)).apply(5));


        //identity static method
        Function<Integer, Integer> i = Function.identity();
        System.out.println("identity " + i.apply(10));
    }
}

class PersonEntity {
    private String name;
    private int age;

    public PersonEntity(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class PersonDTO {
    private String name;
    private int age;

    public PersonDTO(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
