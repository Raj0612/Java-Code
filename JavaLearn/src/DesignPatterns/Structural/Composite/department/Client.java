package DesignPatterns.Structural.Composite.department;

public class Client {

    public static void main(String args[]) {
        Department salesDepartment = new SalesDepartment(1, "Sales department");
        Department financialDepartment = new FinancialDepartment(  2, "Financial department");

        HeadDepartment headDepartment = new HeadDepartment( 3, "Head department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);



        Department salesDepartment1 = new SalesDepartment(4, "Sales department1");
        Department financialDepartment1 = new FinancialDepartment(  5, "Financial department1");

        HeadDepartment headDepartment1 = new HeadDepartment( 6, "Head department1");

        headDepartment1.addDepartment(salesDepartment1);
        headDepartment1.addDepartment(financialDepartment1);

        headDepartment.addDepartment(headDepartment1);


        headDepartment.printDepartmentName();
    }
}
