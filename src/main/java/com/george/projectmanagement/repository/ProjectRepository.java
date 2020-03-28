package com.george.projectmanagement.repository;

import com.george.projectmanagement.model.Project;
import com.george.projectmanagement.repository.impl.ProjectStage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends CrudRepository <Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as stage, COUNT(*) as count " +
            "FROM project " +
            "GROUP BY stage")
    public List<ProjectStage> projectStages();



    //
}
