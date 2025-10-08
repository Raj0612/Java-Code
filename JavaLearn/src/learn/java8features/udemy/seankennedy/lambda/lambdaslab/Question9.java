package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Refactor 6b, 7b and 8b to use method references instead of lambda expressions.
public class Question9 {

    public static void main(String[] args) {
        new Question9().answer6bMR();
        new Question9().answer7bMR();
        new Question9().answer8bMR();
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8f));
        result.add(new Person("Mary", 25, 1.4f));
        result.add(new Person("Alan", 34, 1.7f));
        result.add(new Person("Zoe", 30, 1.5f));
        return result;
    }

    private void answer6bMR() {
        List<Person> listPeople = getPeople();
        //var listPeople = getPeople();
        System.out.println(":Answer 6b MR:");
        listPeople.sort(Comparator.comparing(Person::getAge));
        listPeople.forEach(System.out::println);
    }

    private void answer7bMR() {
        List<Person> listPeople = getPeople();
        //var listPeople = getPeople();
        System.out.println(":Answer 7b MR:");
        listPeople.sort(Comparator.comparing(Person::getName));
        listPeople.forEach(System.out::println);
    }

    private void answer8bMR() {
        List<Person> listPeople = getPeople();
        //var listPeople = getPeople();
        System.out.println(":Answer 8b MR:");
        listPeople.sort(Comparator.comparing(Person::getHeightInMeters));
        listPeople.forEach(System.out::println);
    }


    private static class Person {

        private String name = "";
        private float heightInMeters = 0;
        private int age = 0;

        public Person(String name, int age, float heightInMeters){
            this.name = name;
            this.heightInMeters = heightInMeters;
            this.age = age;
        };

        public String getName() {
            return name;
        }

        public float getHeightInMeters() {
            return heightInMeters;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", heightInMeters=" + heightInMeters +
                    ", age=" + age +
                    '}';
        }

    }
}
