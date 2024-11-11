package company.adapter;

import company.directory.Employee;

import java.util.ArrayList;
import java.util.List;

public class ArrayStore implements Store {
    private List<Employee> items = new ArrayList<>();

    @Override
    public Employee create(Employee e) {
        items.add(e);
        return e;
    }

    @Override
    public Employee read(int eid) {
        // Find employee by ID
        for (Employee emp : items) {
            if (emp.getEid() == eid) {
                return emp;
            }
        }
        return null;  // Return null if employee with the given ID is not found
    }

    @Override
    public List<Employee> read(String name) {
        // Find employees by name
        List<Employee> result = new ArrayList<>();
        for (Employee emp : items) {
            if (emp.getName().equalsIgnoreCase(name)) {
                result.add(emp);
            }
        }
        return result;
    }
}
