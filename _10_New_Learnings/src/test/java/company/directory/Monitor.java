package company.directory;


import company.utils.NotificationService;

import java.util.List;

public class Monitor extends Directory {
    private Directory target;

    public Monitor(Directory target) {
        this.target = target;
    }

    @Override
    public Employee add(Employee e) {
        long startTime = System.currentTimeMillis();

        // Pre-processing: Adding Employee
        System.out.println("Starting add() method.");

        Employee emp = target.add(e);

        // Post-processing: Notification and Performance Logging
        NotificationService.sendSmsNotification(
                String.valueOf(e.getPhone()),
                "Employee added: " + e.getName() + " (ID: " + e.getEid() + ")"
        );

        long endTime = System.currentTimeMillis();
        System.out.println("add() method completed. Time taken: " + (endTime - startTime) + " ms.");

        return emp;
    }

    @Override
    public List<Employee> search(String key) {
        long startTime = System.currentTimeMillis();

        // Pre-processing: Search Employees
        System.out.println("Starting search() method.");

        List<Employee> employees = target.search(key);

        // Post-processing: Notification and Performance Logging
        for (Employee emp : employees) {
            NotificationService.sendSmsNotification(
                    String.valueOf(emp.getPhone()),
                    "Employee found with name: " + emp.getName()
            );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("search() method completed. Time taken: " + (endTime - startTime) + " ms.");

        return employees;
    }

    @Override
    public Employee find(int eid) {
        long startTime = System.currentTimeMillis();

        // Pre-processing: Finding Employee
        System.out.println("Starting find() method.");

        Employee emp = target.find(eid);

        // Post-processing: Notification and Performance Logging
        if (emp != null) {
            NotificationService.sendSmsNotification(
                    String.valueOf(emp.getPhone()),
                    "Employee found with ID: " + emp.getEid()
            );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("find() method completed. Time taken: " + (endTime - startTime) + " ms.");

        return emp;
    }
}
