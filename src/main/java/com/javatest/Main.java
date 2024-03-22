package com.javatest;
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
// import org.junit.jupiter.api.Test;

public class Main {
  public static void main(String[] args) {

    /****************** Student Activity-1 **************/
    try {
      // Create a new file object
      File myFile = new File("mydata.txt");

      // Check if file already exists
      if (myFile.createNewFile()) {
        System.out.println("File created: " + myFile.getName());
      } else {
        System.out.println("File already exists.");
      }

      // Write content to the file
      FileWriter writer = new FileWriter(myFile);
      writer.write("This is some data written to the file.\n");
      writer.write("You can write multiple lines using newLine().");
      writer.close(); // Important to close the stream

      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }


    /**************** Student Activity-3 *****************/
    DepartmentManager dms = new DepartmentManager();

    // Adding departments
    Department hrDepartment = new Department("Human Resources");
    Department itDepartment = new Department("Information Technology");

    dms.addDepartment(hrDepartment);
    dms.addDepartment(itDepartment);
    // Adding employees
    hrDepartment.addEmployee(new Employee(101, "John Doe", 50000));
    hrDepartment.addEmployee(new Employee(102, "Jane Smith", 60000));
    itDepartment.addEmployee(new Employee(201, "Michael Johnson", 70000));
    itDepartment.addEmployee(new Employee(202, "Emily Davis", 55000));

    // Writing data to file
    dms.writeDataToFile("departments.txt");
  }
}