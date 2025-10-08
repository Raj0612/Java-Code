package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.ArrayList;
import java.util.List;

/*In main(), invoke the sortAge() method passing down listPeople; in sortAge() do the following:

        a) Using the Iterable sort() method (note: List extends Iterable), and the Comparator.comparing() method, sort the Person objects in ascending age order.
         Note that the argument to Comparator.comparing() requires a Function (In, Out) that returns a Comparable (a class that implements Comparable).
          From that, the comparing() method generates a Comparator that it passes to the sort() method.

        - Note that as of Java 8, the List interface supports the sort() method directly so there is no need to use the Collections.sort():
        i.e. instead of Collections.sort(list, comparatorRef); we now have list.sort(comparatorRef);

        b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.*/
public class Question6 {

    public static void main(String[] args) {
        new Question6().answer();
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
        listPeople.sort((o1, o2) -> o1.getAge() - o2.getAge());
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
