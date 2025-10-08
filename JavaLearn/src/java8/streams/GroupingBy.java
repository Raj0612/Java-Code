package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingBy {
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

        groupingUsingLambda(courses);
        groupingUsingMethodReference(courses);
    }

    private static void groupingUsingLambda(List<Course> courses) {
        // Group Courses by Category
        Map<String, List<Course>> coursesByCategory = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory()));

        System.out.println("Courses by Category: " + coursesByCategory);
        System.out.println();

        // Count Courses in Each Category
        Map<String, Long> courseCountByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(), Collectors.counting()));

        System.out.println("Count Courses in Each Category: " + courseCountByCategory);
        System.out.println();

        // Find Highest Rated Course in Each Category
        Map<String, Optional<Course>> highestRatedCourseByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore()))
                ));

        System.out.println("Highest Rated Course in Each Category: " + highestRatedCourseByCategory);
        System.out.println();

        // Get List of Course Names per Category
        Map<String, List<String>> courseNamesByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.mapping(course -> course.getName(), Collectors.toList())
                ));

        System.out.println("List of Course Names per Category: " + courseNamesByCategory);
    }

    private static void groupingUsingMethodReference(List<Course> courses) {
        //Group Courses by Category
        Map<String, List<Course>> coursesByCategory = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory));

        System.out.println("Courses by Category: " + coursesByCategory);
        System.out.println();
        //Count Courses in Each Category
        Map<String, Long> courseCountByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory, Collectors.counting()));

        System.out.println("Count Courses in Each Category: " + courseCountByCategory);
        System.out.println();

        //Find Highest Rated Course in Each Category
        Map<String, Optional<Course>> highestRatedCourseByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))
                ));

        System.out.println("Highest Rated Course in Each Category: " + highestRatedCourseByCategory);
        System.out.println();

        //Get List of Course Names per Category
        Map<String, List<String>> courseNamesByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())
                ));

        System.out.println("List of Course Names per Category: " + courseNamesByCategory);
    }
}
