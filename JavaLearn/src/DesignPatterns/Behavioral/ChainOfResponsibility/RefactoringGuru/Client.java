package DesignPatterns.Behavioral.ChainOfResponsibility.RefactoringGuru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );
        System.out.println("middleware start " + middleware);
        server.setMiddleware(middleware);
    }
        public static void main(String[] args) throws IOException {
            init();

            boolean success;
            do {
                System.out.print("Enter email: ");
                String email = reader.readLine();
               // String email = "admin@example.com";
                // System.out.print("Input password: ");
                String password = reader.readLine();
              //  String password = "admin_pass";
                success = server.logIn(email, password);
            } while (!success);
        }

}
