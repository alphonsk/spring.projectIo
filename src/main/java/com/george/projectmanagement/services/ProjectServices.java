package com.george.projectmanagement.services;

import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.repository.ProjectRepository;
import com.george.projectmanagement.repository.impl.ProjectStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<ProjectStage> projectStages(){
        return projectRepository.projectStages();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }

    public void delete(Project pro) {
        projectRepository.delete(pro);
    }

//
}
