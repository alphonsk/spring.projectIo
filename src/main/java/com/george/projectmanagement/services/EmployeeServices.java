package com.george.projectmanagement.services;


import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.repository.EmployeeRepository;
import com.george.projectmanagement.repository.ProjectRepository;
import com.george.projectmanagement.repository.impl.Employeeproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> findAllByid(List<Long> employees){
        return employeeRepository.findAllById(employees);
    }

    public List<Employeeproject> employeeprojects(){
        return employeeRepository.employeeprojects();
    }

    public Employee findByid(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(Employee emp) {
        employeeRepository.delete(emp);
    }


//    public List<UserAccount> getAll(){
//        List<UserAccount> userList = new ArrayList<>();
//        Iterable<UserAccount> userAccounts = accountRepository.findAll();
//        userAccounts.forEach(userList::add);
//        return userList;
//    }


    //
}
