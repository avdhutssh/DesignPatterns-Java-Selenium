
package company.directory;

import java.util.List;

public abstract class Directory {
    public abstract Employee add(Employee e);

    public abstract List<Employee> search(String key);

    public abstract Employee find(int eid);
}
        