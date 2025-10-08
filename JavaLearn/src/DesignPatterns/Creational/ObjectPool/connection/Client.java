package DesignPatterns.Creational.ObjectPool.connection;


import java.sql.Connection;

public class Client {

    public static void main(String args[]) {
       JDBCConnectionPool pool = new JDBCConnectionPool(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://APT04-BJTK573:1433;databaseName=PCUser50;useLOBs=false",
                "sa", "abc-123");

        Connection con = pool.takeOut();
        pool.takeIn(con);
    }
}
