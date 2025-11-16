package com.data.connection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpReposotory empReposotory;
   // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee,empEntity);
        empReposotory.save(empEntity);
        //employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> empEntities = empReposotory.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmpEntity empEntity : empEntities) {
            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setLastName(empEntity.getLastName());
            emp.setFirstName(empEntity.getFirstName());
            emp.setEmail(empEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmpEntity empEntity = empReposotory.findById(id).get();
        empReposotory.delete(empEntity);
        //employees.remove(id);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmpEntity exestingEmp = empReposotory.findById(id).get();
        exestingEmp.setEmail(employee.getEmail());
        exestingEmp.setFirstName(employee.getFirstName());
        exestingEmp.setLastName(employee.getLastName());
        empReposotory.save(exestingEmp);

        return "Updated Successfully";
    }

    @Override
    public Employee readEmployeeId(Long id) {
        Employee emp = new Employee();
        EmpEntity empEntity = empReposotory.findById(id).get();
        emp.setId(empEntity.getId());
        emp.setLastName(empEntity.getLastName());
        emp.setFirstName(empEntity.getFirstName());
        emp.setEmail(empEntity.getEmail());
        return emp;
    }

}
