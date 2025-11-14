package com.data.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    //EmpService empService = new EmpServiceImp();

    //Dependcy Injection
    @Autowired(required=true)
    EmpService empService;


    @GetMapping("employee")
    public List<Employee> getAllEmployees(){
        return empService.readEmployees();
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee employee){
        return empService.createEmployee(employee);

    }
    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(empService.deleteEmployee(id))
            return "Employee deleted successfully";
        else
            return "Employee not deleted";
    }
    @PutMapping("employee/{id}")
    public String updatedEmployee(@PathVariable Long id, @RequestBody Employee employee){
            return empService.updateEmployee(id,employee);
    }
}
