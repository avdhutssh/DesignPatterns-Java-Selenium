
package company.directory;

public class Employee {
    private final int eid;
    private String name;
    private long phone;

    public Employee(int eid, String name, long phone) {
        this.eid = eid;
        this.name = name;
        this.phone = phone;
    }

    public int getEid() {
        return eid;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }
}
        