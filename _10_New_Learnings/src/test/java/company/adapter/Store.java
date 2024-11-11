
package company.adapter;

import company.directory.Employee;

import java.util.List;

public interface Store {
    Employee create(Employee e);

    Employee read(int eid);

    List<Employee> read(String name);
}
        