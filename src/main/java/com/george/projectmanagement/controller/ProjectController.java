package com.george.projectmanagement.controller;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.services.EmployeeServices;
import com.george.projectmanagement.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectServices projectServices;

    @Autowired
    EmployeeServices employeeServices;
    

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectServices.findAll();
        model.addAttribute("projects", projects);
        return "project/projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> employees = employeeServices.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("employees", employees);
        return "project/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectServices.save(project);
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects ";

    }

}
