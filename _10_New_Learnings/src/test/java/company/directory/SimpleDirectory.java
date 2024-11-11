
package company.directory;


import company.adapter.Store;

import java.util.ArrayList;
import java.util.List;

public class SimpleDirectory extends Directory {
    private List<Employee> employees = new ArrayList<>();
    private Store store;

    public SimpleDirectory(Store store) {
        this.store = store;
    }

    @Override
    public Employee add(Employee e) {
        employees.add(e);
        return e;
    }

    @Override
    public List<Employee> search(String key) {
        return store.read(key);
    }

    @Override
    public Employee find(int eid) {
        return store.read(eid);
    }
}
        