package com.javatest;

import java.io.*;
import java.util.*;

public class DepartmentManager {
  private List<Department> departments;

  public DepartmentManager() {
    this.departments = new ArrayList<Department>();
  }

  public void addDepartment(Department department) {
    departments.add(department);
  }

  public void removeDepartment(Department department) {
    departments.remove(department);
  }

  public List<Department> getDepartments() {
    return departments;
  }

  public void writeDataToFile(String fileName) {
    try {
      File myFile = new File(fileName);
      // Check if file already exists
      if (myFile.createNewFile()) {
        System.out.println("File created: " + myFile.getName());
        FileWriter fileWriter = new FileWriter(myFile);
        PrintWriter writer = new PrintWriter(fileWriter);
         
          for (Department department : departments) {
             writer.println("Department: " + department.getName());
            for (Employee employee : department.getEmployees()) {
                writer.println(employee);
            }
          }
          writer.println(); // Add an empty line to separate departments
        writer.close();
        fileWriter.close();
        }else {
        System.out.println("File already exists.");
      }

      System.out.println("Data written to file successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}