package company.main;


import company.directory.Directory;
import company.directory.Employee;
import company.factory.Factory;
import company.factory.SimpleFactory;

import java.util.List;


public class Client {
    public static void main(String[] args) {
        Factory factory = new SimpleFactory();
        Directory directory = factory.getDirectory();

        // Add employees
        Employee emp1 = new Employee(1, "John Doe", 1234567890L);
        directory.add(emp1);

        Employee emp2 = new Employee(2, "Jane Smith", 9876543210L);
        directory.add(emp2);

        System.out.println("Employees added: " + emp1.getName() + ", " + emp2.getName());

        // Search employees by name
        List<Employee> searchResults = directory.search("John Doe");
        System.out.println("Search results for 'John Doe':");
        for (Employee emp : searchResults) {
            System.out.println(" - " + emp.getName() + " (ID: " + emp.getEid() + ")");
        }

        // Find employee by ID
        Employee foundEmployee = directory.find(2);
        if (foundEmployee != null) {
            System.out.println("Employee found with ID 2: " + foundEmployee.getName());
        } else {
            System.out.println("No employee found with ID 2.");
        }
    }
}
