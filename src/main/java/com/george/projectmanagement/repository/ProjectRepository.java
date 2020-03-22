package com.george.projectmanagement.repository;

import com.george.projectmanagement.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends CrudRepository <Project, Long> {

    @Override
    public List<Project> findAll();
}
