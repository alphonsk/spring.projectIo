package com.george.projectmanagement.repository;

import com.george.projectmanagement.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")
//})
public class ProjectRepositoryIntergrationTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSuccess(){
        int currentProjects = projectRepository.findAll().size();
        Project project = new Project("new test project", "COMPLETE", "Test description");
        projectRepository.save(project);

        assertEquals(currentProjects + 1, projectRepository.findAll().size());
    }


    // end
}
