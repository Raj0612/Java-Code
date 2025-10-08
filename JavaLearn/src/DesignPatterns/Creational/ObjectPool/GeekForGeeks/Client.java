package DesignPatterns.Creational.ObjectPool.GeekForGeeks;

import java.sql.Connection;

public class Client {
    public static void main(String[] args) {
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb: //localhost/mydb",
                "sa", "password");

        Connection con = pool.takeOut();

        pool.takeIn(con);

    }
}
