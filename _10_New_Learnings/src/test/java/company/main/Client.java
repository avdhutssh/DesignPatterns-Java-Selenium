
package company.main;

import company.directory.Directory;
import company.directory.Employee;
import company.factory.Factory;
import company.factory.SimpleFactory;

public class Client {
    public static void main(String[] args) {
        Factory factory = new SimpleFactory();
        Directory directory = factory.getDirectory();

        Employee emp1 = new Employee(1, "John Doe", 1234567890L);
        directory.add(emp1);

        System.out.println("Employee added: " + emp1.getName());
    }
}
        