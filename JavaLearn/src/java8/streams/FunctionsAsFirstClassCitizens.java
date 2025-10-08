package java8.streams;

import java8.streams.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionsAsFirstClassCitizens {

    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>(Arrays.asList(
                new Course("AWS", "Cloud", 95, 200000),
                new Course("Azure", "Cloud", 90, 150000),
                new Course("Docker", "Cloud", 85, 180000),
                new Course("Kubernetes", "Cloud", 88, 170000),
                new Course("Spring", "Framework", 97, 220000),
                new Course("Spring Boot", "Framework", 93, 210000),
                new Course("Microservices", "Microservices", 98, 250000),
                new Course("FullStack", "FullStack", 96, 230000)
        ));

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        returningAFunction(courses);
        passingAFunction(numbers);
    }

    static void returningAFunction(List<Course> courses) {

        Predicate<Course> highScore = createPredicate(95);
        List<Course> filtered = courses.stream()
                .filter(highScore)
                .collect(Collectors.toList());

        System.out.println("returningAFunction " + filtered);

    }

    public static Predicate<Course> createPredicate(int cutoff) {
        return course ->
                course.getReviewScore() > cutoff;
    }

    public  static  void passingAFunction(List<Integer> numbers) {
        filterAndPrint(numbers, x -> x % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);
        filterAndPrint(numbers, x -> x % 3 == 0);
    }

    public static void filterAndPrint(List<Integer> numbers,  Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);

    }
}
