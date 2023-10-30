package com.dailycodebuffer.employeesystemapi.services;

import com.dailycodebuffer.employeesystemapi.entity.EmployeeEntity;
import com.dailycodebuffer.employeesystemapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    boolean deleteEmployee(long id);

    Employee getEmployeeByid(long id);

    Employee updateEmployee(long id, Employee employee);
}
