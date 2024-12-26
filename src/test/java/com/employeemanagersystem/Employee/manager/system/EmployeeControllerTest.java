package com.employeemanagersystem.Employee.manager.system;

import com.employeemanagersystem.Employee.manager.system.controller.EmployeeController;
import com.employeemanagersystem.Employee.manager.system.exception.ResourceNotFoundException;
import com.employeemanagersystem.Employee.manager.system.model.Employee;
import com.employeemanagersystem.Employee.manager.system.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John", "Doe", "john.doe@example.com"));
        employees.add(new Employee(2L, "Jane", "Smith", "jane.smith@example.com"));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeController.getAllEmployees();
        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeController.createEmployee(employee);
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);
        assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getFirstName());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeController.getEmployeeById(1L);
        });

        assertEquals("Employee not exist with id: 1", exception.getMessage());
    }

    @Test
    void testUpdateEmployee() {
        Employee existingEmployee = new Employee(1L, "John", "Doe", "john.doe@example.com");
        Employee updatedEmployee = new Employee(1L, "John", "Smith", "john.smith@example.com");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(existingEmployee));
        when(employeeRepository.save(existingEmployee)).thenReturn(updatedEmployee);

        ResponseEntity<Employee> response = employeeController.updateEmployee(1L, updatedEmployee);
        assertNotNull(response.getBody());
        assertEquals("Smith", response.getBody().getLastName());
        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).save(existingEmployee);
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepository).delete(employee);

        Map<String, Boolean> response = employeeController.deleteEmployee(1L);
        assertTrue(response.get("deleted"));
        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).delete(employee);
    }

    @Test
    void testDeleteEmployeeNotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            employeeController.deleteEmployee(1L);
        });

        assertEquals("Employee not exest with id:1", exception.getMessage());
    }
}
