package com.javatest;

class Employee {
  private String name;
  private int id;
  private double salary;
  public Employee(int id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }
  public String getName() {
      return name;
  }

  public int getId() {
      return id;
  }

  public double getSalary() {
      return salary;
  }
  @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
    }
}
