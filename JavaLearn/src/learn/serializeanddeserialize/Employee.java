package learn.serializeanddeserialize;

import java.io.Serializable;

public class Employee implements Serializable {
   private static final long serialVersionUID = -299482035708790407L;

    int test1 =1001 ;
    private String name;
    private int id;
    transient private int salary;
	private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }




    @Override
    public String toString() {
        return "Employee{name="+name+",id="+id+",salary="+salary+"}";
    }

}
