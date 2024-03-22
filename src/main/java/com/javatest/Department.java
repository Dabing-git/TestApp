package com.javatest;

import java.util.*;
import com.javatest.*;

class Department {
  private String name;
  private List<Employee> employees;

  public Department(String name) {
    this.name = name;
    this.employees = new ArrayList<Employee>();
  }
  public String getName() {
      return name;
  }

  public List<Employee> getEmployees() {
      return employees;
  }

  public void addEmployee(Employee employee) {
      employees.add(employee);
  }

  public void removeEmployee(Employee employee) {
      employees.remove(employee);
  }

  @Override
  public String toString() {
      return "Department [name=" + name + ", employees=" + employees + "]";
  }
}
