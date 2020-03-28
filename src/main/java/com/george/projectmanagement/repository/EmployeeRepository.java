package com.george.projectmanagement.repository;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.repository.impl.Employeeproject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value= "SELECT emp.first_name as firstName,  emp.last_name as lastName, emp.email, COUNT(pro.employee_id) as projectCount " +
            "FROM employee emp left join project_employee pro on pro.employee_id = emp.employee_id " +
            "GROUP BY  emp.first_name , emp.last_name order by 3 desc;")
    public List<Employeeproject> employeeprojects();



}
