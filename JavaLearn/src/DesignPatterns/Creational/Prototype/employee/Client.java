package DesignPatterns.Creational.Prototype.employee;


import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {

        /*BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Employee Id: ");
        int eid=Integer.parseInt(br.readLine());
        System.out.print("\n");

        System.out.print("Enter Employee Name: ");
        String ename=br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Designation: ");
        String edesignation=br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Address: ");
        String eaddress=br.readLine();
        System.out.print("\n");

        System.out.print("Enter Employee Salary: ");
        double esalary= Double.parseDouble(br.readLine());
        System.out.print("\n");*/

        int eid = 1;
        String ename = "Raj";
        String edesignation = "Lead";
        double esalary = 1.500000;
        String eaddress = "ECity";


        EmployeeRecord e1=new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);

        e1.showRecord();
        System.out.println("\n");
        EmployeeRecord e2=(EmployeeRecord) e1.getClone();
        e2.showRecord();
        e2.setEname("Sekar");
        e2.showRecord();
        e1.showRecord();
    }
}
