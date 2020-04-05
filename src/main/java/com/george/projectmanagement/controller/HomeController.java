package com.george.projectmanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.repository.EmployeeRepository;
import com.george.projectmanagement.repository.ProjectRepository;
import com.george.projectmanagement.repository.impl.Employeeproject;
import com.george.projectmanagement.repository.impl.ProjectStage;
import com.george.projectmanagement.services.EmployeeServices;
import com.george.projectmanagement.services.HomeService;
import com.george.projectmanagement.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    // read values from aplicationresource file
    @Value("${foo}")
    private String foo;
    
    @Autowired
    HomeService homeService;

    @Autowired
    ProjectServices projectServices;
    @Autowired
    EmployeeServices employeeServices;



    @GetMapping("/")
    public String displayAll(Model model) throws JsonProcessingException {
        List<Project> projects = projectServices.findAll();
        List<Employee> employees = employeeServices.findAll();
        List<Employeeproject> employeeProjectsCounts = employeeServices.employeeprojects();
        List<ProjectStage> projectStages = projectServices.projectStages();
        // turn projectStages to json
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProjectStages = objectMapper.writeValueAsString(projectStages);

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        model.addAttribute("employeeProjectsCounts", employeeProjectsCounts);
        model.addAttribute("projectStages", projectStages);
        model.addAttribute("jsonProjectStages", jsonProjectStages);


        model.addAttribute("foo", foo);

        return "main/home";
    }



    // end
}
