package com.employeemanagersystem.Employee.manager.system.repository;

import com.employeemanagersystem.Employee.manager.system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
