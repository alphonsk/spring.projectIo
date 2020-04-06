package com.george.projectmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    @Size(min=2, max=32, message="Last name must be between 1 and 32 characters")
    private String firstName;
    @NotNull
    @Pattern(regexp="^(?=\\s*\\S).*$", message="Last name must be between 1 and 32 characters")
    @Size(min=2, max=32)
    private String lastName;
    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
    private String email;

//    @NotNull(message="Please enter a number of hours per week")
//    @Min(10)
//    @Max(40)
//    private Integer hoursPerWeek;
//
//    @NotNull(message="Please enter an SSN")
//    @Pattern(regexp = "^[0-9][0-9]{2}-[0-9]{2}-[0-9]{4}$", message="SSN must use numbers in this format: XXX-YY-ZZZZ")
//    private String ssn;
//
//    @NotNull
//    @Pattern(regexp="^(?=\\s*\\S).*$", message="Please select a city")
//    private String city;



    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",
            joinColumns= @JoinColumn(name = "employee_id"),
            inverseJoinColumns= @JoinColumn(name = "project_id")
    )
    //    Stops the find all loop because of manytomany association
    @JsonIgnore
    private List<Project> theProjects;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getTheProjects() {
        return theProjects;
    }

    public void setTheProjects(List<Project> theProjects) {
        this.theProjects = theProjects;
    }

    // END
}
