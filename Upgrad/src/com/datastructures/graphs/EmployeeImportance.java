package com.datastructures.graphs;
//You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
//You are given an array of employees where:
/*
1) employees[i].id is the ID of the ith employee.
2) employees[i].importance is the importance value of the ith employee.
3) employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
 */
//Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

/*
Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.

Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
Output: -3
Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
Thus, the total importance value of employee 5 is -3.
 */

import java.util.*;
public class EmployeeImportance {

    static  int totalImportance;

    static HashMap<Integer, Employee> employeeMap = new HashMap<>();
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 5;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        emp1.subordinates = list;

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        list  = new ArrayList<>();
        list.add(4);
        list.add(5);
        emp2.subordinates = list;

        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        list  = new ArrayList<>();
        emp3.subordinates = list;

        Employee emp4 = new Employee();
        emp4.id = 4;
        emp4.importance = 3;
        list  = new ArrayList<>();
        emp4.subordinates = list;

        Employee emp5 = new Employee();
        emp5.id = 5;
        emp5.importance = 3;
        list  = new ArrayList<>();
        emp5.subordinates = list;

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        int id = 1;
        employeeMap = new HashMap<>();
        System.out.println("input1 getImportance: " + getImportance(employees, id));
    }

    static void input2(){
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 2;
        List<Integer> list = new ArrayList<>();
        list.add(5);
        emp1.subordinates = list;

        Employee emp2 = new Employee();
        emp2.id = 5;
        emp2.importance = -3;
        list  = new ArrayList<>();
        emp2.subordinates = list;

        int id = 5;
        totalImportance = 0;
        employeeMap = new HashMap<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        System.out.println("input2 getImportance: " + getImportance(employees, id));
    }

    public static int getImportance(List<Employee> employees, int id) {

        for(int i=0; i< employees.size(); i++){
            employeeMap.put(employees.get(i).id, employees.get(i));
        }
        System.out.println("employeeMap " + employeeMap);
      //  dfs(employees, id);
        totalImportance =  bfs(employees, id);

        return totalImportance;
    }

    static void dfs(List<Employee> employees, int id){
        //It will iterate for every call. Instead add in map and get in O(1)
//        Employee emp = employees.stream()
//                .filter(employee -> id == employee.id)
//                .findAny()
//                .orElse(null);
        Employee emp =  employeeMap.get(id);
        int importance = emp.importance;

        totalImportance = totalImportance + importance;
        for(int i=0; i< emp.subordinates.size(); i++){
            dfs(employees, emp.subordinates.get(i));
        }
    }

    static int bfs(List<Employee> employees, int id){

        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(employeeMap.get(id));

        int  totalImportance = 0;
        while(!queue.isEmpty()){
            Employee emp =  queue.poll();
            totalImportance = totalImportance + emp.importance;

            for(int i = 0; i< emp.subordinates.size(); i++){
                queue.add(employeeMap.get(emp.subordinates.get(i)));
            }
        }

        return totalImportance;

    }
}
