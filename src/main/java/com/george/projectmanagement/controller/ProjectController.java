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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "project/projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("employees", employees);
        return "project/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects ";

    }

}
