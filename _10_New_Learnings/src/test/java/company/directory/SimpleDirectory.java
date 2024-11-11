package company.directory;


import company.adapter.Store;

import java.util.List;

public class SimpleDirectory extends Directory {
    private Store store;

    public SimpleDirectory(Store store) {
        this.store = store;
    }

    @Override
    public Employee add(Employee e) {
        // Use store to create (add) employee
        return store.create(e);
    }

    @Override
    public List<Employee> search(String key) {
        // Use store to search employees by name
        return store.read(key);
    }

    @Override
    public Employee find(int eid) {
        // Use store to find employee by ID
        return store.read(eid);
    }
}
