package com.dailycodebuffer.employeesystemapi.repository;

import com.dailycodebuffer.employeesystemapi.entity.EmployeeEntity;
import com.dailycodebuffer.employeesystemapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
