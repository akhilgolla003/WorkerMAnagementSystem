package com.dailycodebuffer.employeesystemapi.services;

import com.dailycodebuffer.employeesystemapi.entity.EmployeeEntity;
import com.dailycodebuffer.employeesystemapi.model.Employee;
import com.dailycodebuffer.employeesystemapi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        //copy from source:employee to destination : employeeEntity
        BeanUtils.copyProperties(employee, employeeEntity);
        repository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = repository.findAll();

        //now convert Employee entity to list of employees for the UI(model).
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp-> new Employee(emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;


    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity employee = repository.findById(id).get();
        repository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeByid(long id) {
        EmployeeEntity e =
                repository.findById(id).get();

        Employee employee =
                new Employee();

        BeanUtils.copyProperties(e, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity employeeEntity =
                repository.findById(id).get();

        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        repository.save(employeeEntity);

        return employee;
    }
}
