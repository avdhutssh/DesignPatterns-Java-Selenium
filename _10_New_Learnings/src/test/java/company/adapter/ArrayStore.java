
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
        return items.stream().filter(emp -> emp.getEid() == eid).findFirst().orElse(null);
    }

    @Override
    public List<Employee> read(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : items) {
            if (emp.getName().equalsIgnoreCase(name)) {
                result.add(emp);
            }
        }
        return result;
    }
}
        