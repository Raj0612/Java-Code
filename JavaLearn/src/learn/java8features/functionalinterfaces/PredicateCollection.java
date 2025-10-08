package learn.java8features.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCollection {

    public static void main(String args[]) {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
        //By stream APi
        List admins1 = users.stream()
                .filter((user) -> user.getRole().equals("admin"))
                .collect(Collectors.toList());
        System.out.println(admins1);
    }
    public static List<User> process(List<User> users,
                                     Predicate<User> predicate) {
        List<User> result = new ArrayList<User>();
        for (User user: users)
            if (predicate.test(user))
                result.add(user);
        return result;
    }
}

class User{
    String name, role;
    User(String a, String b) {
        name = a;
        role = b;
    }
    String getRole() { return role; }
    String getName() { return name; }
    public String toString() {
        return "User Name : " + name + ", Role :" + role;
    }
}
