package com.datastructures.graphs;

import java.util.List;

public class Employee {
    int id;
    int importance;
    public List<Integer> subordinates;
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}
