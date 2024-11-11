package company.adapter;

import company.directory.Employee;

import java.util.ArrayList;
import java.util.List;

public class ArrayStore implements Store {
    private List<Employee> items = new ArrayList<>();
    private static ArrayStore INSTANCE;

    // Private constructor to prevent direct instantiation
    private ArrayStore() {
    }

    // Static method to provide a single instance
    public static synchronized ArrayStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ArrayStore();
        }
        return INSTANCE;
    }

    @Override
    public Employee create(Employee e) {
        System.out.println("Adding employee: " + e.getName() + " (ID: " + e.getEid() + ")");
        items.add(e);
        return e;
    }

    @Override
    public Employee read(int eid) {
        System.out.println("Searching for employee with ID: " + eid);
        for (Employee emp : items) {
            if (emp.getEid() == eid) {
                System.out.println("Found employee with ID " + eid + ": " + emp.getName());
                return emp;
            }
        }
        System.out.println("No employee found with ID: " + eid);
        return null;
    }

    @Override
    public List<Employee> read(String name) {
        System.out.println("Searching for employees with name: " + name);
        List<Employee> result = new ArrayList<>();
        for (Employee emp : items) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println("Found employee with name " + name + ": " + emp.getName());
                result.add(emp);
            }
        }
        return result;
    }
}
