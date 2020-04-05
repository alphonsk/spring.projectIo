package com.george.projectmanagement.apiController;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.services.EmployeeServices;
import com.george.projectmanagement.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {

    @Autowired
    ProjectServices projectServices;

    @Autowired
    EmployeeServices employeeServices;


    @GetMapping
    public List<Project> displayProjects() {
        return projectServices.findAll();
    }

    @GetMapping("/{id}")
    public Project displayProject(@PathVariable Long id) {
        return projectServices.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // optional
    public Project newProject(@RequestBody Project project) {
        projectServices.save(project);
        return project;
    }

    @PutMapping("/{id}")
    public Project editProject(@PathVariable Long id, @RequestBody Project project) {
        projectServices.save(project);
        return project;
    }

    @PatchMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project pro = projectServices.findById(id);

        if (project.getName() != null) {
            pro.setName(project.getName());
        }
        if (project.getStage() != null) {
            pro.setStage(project.getStage());
        }
        if (project.getDescription() != null) {
            pro.setDescription(project.getDescription());
        }

        projectServices.save(pro);
        return project;
    }

    @DeleteMapping("/{id}")
    public Project deleteProject(@PathVariable Long id) {
        Project pro = projectServices.findById(id);
        projectServices.delete(pro);
        return pro;
    }



//
}
