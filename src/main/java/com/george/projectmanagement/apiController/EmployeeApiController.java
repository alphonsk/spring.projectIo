package com.george.projectmanagement.apiController;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping
    public List<Employee> displayEmployees() {
        return employeeServices.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeServices.findByid(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // optional
    public Employee newEmployee(@RequestBody Employee employee){
        employeeServices.save(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp = employeeServices.findByid(id);

        if (employee.getFirstName() != null){
            emp.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null){
            emp.setLastName(employee.getLastName());
        }
        if (employee.getEmail() != null){
            emp.setEmail(employee.getEmail());
        }

        employeeServices.save(emp);
        return emp;
    }


    @PatchMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp = employeeServices.findByid(id);

        if (employee.getFirstName() != null){
            emp.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null){
            emp.setLastName(employee.getLastName());
        }
        if (employee.getEmail() != null){
            emp.setEmail(employee.getEmail());
        }

        employeeServices.save(emp);
        return emp;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        Employee emp = employeeServices.findByid(id);
        employeeServices.delete(emp);
        return emp;
    }




//    @GetMapping("/new")
//    public Employee displayProjectForm(@RequestBody Employee employee) {
//        employeeServices.save(employee);
//        return  employee;
//    }
//
//    @PostMapping("/save")
//    public Employee createProject(Employee employee) {
//        employeeServices.save(employee);
//        // use a redirect to prevent duplicate submissions
//        return "redirect:/employees";
//    }


    // end
}
