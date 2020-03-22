package com.george.projectmanagement.controller;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.repository.EmployeeRepository;
import com.george.projectmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/")
    public String displayAll(Model model) {
        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);

        return "main/home";
    }



    // end
}
