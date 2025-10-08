package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.ArrayList;
import java.util.List;

/*Given the following implementation of the getPeople() method:

private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
        In main(), invoke the getPeople() – store the result in a variable named listPeople.*/
public class Question5 {
    public static void main(String[] args) {
        new Question5().answer();
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
        for(Person person : listPeople){
            System.out.println(person);
        }
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
