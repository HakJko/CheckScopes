package com.rd.epam.autotasks.scopes.config.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmployeeBean {

    private static long counter;
    private long id;
    private String name;

    private EmployeeBean() {}

    public static EmployeeBean getEmployee() {
        threeTimes();
        EmployeeBean e = new EmployeeBean();
        e.setId(counter++);
        e.setName("Jack");
        return e;
    }

    private static void threeTimes() {
        if (counter == 4) {
            counter = 0;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBean employee = (EmployeeBean) o;
        return id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder employee = new StringBuilder();
        employee.append("Employee[");
        employee.append("id=");
        employee.append(id);
        employee.append(", name=");
        employee.append(name);
        employee.append("]");
        return employee.toString();
    }
}
