package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.ArrayList;
import java.util.List;

/*In main(), invoke the sortHeight() method passing down listPeople; in sortHeight() do the following:

        a) As in 6a except sort the Person objects in ascending height order.

        b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.*/
public class Question8 {

    public static void main(String[] args) {
        new Question8().answer();
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8f));
        result.add(new Person("Mary", 25, 1.4f));
        result.add(new Person("Alan", 34, 1.7f));
        result.add(new Person("Zoe", 30, 1.5f));
        return result;
    }

    private void answer() {
        List<Person> listPeople = getPeople();
        //var listPeople = getPeople();
        listPeople.sort((o1, o2) -> Float.compare(o1.getHeightInMeters(), o2.getHeightInMeters()));
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
