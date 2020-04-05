package com.george.projectmanagement.services;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.repository.EmployeeRepository;
import com.george.projectmanagement.repository.ProjectRepository;
import com.george.projectmanagement.repository.impl.Employeeproject;
import com.george.projectmanagement.repository.impl.ProjectStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

//    List<Project> projects = projectRepository.findAll();
//    List<Employee> employees = employeeRepository.findAll();
//    List<Employeeproject> employeeProjectsCounts = employeeRepository.employeeprojects();
//    List<ProjectStage> projectStages = projectRepository.projectStages();




    //
}
