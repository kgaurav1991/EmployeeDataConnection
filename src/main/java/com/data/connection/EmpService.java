package com.data.connection;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployeeId(Long id);
}
