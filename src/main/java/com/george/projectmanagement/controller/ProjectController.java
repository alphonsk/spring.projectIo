package com.george.projectmanagement.controller;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.services.EmployeeServices;
import com.george.projectmanagement.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String createProject(@Valid Project project, BindingResult bindingResult, Model model) {
        //check for errors
        if (bindingResult.hasErrors()) {
            // return goes to page
            return "project/new-project";
        }

        //if there are no errors, show form success screen
        projectServices.save(project);
        // use a redirect to prevent duplicate submissions
        // redirect goes to mapping url
        return "redirect:/projects ";

    }

}
