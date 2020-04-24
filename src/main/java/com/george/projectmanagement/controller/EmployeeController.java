package com.george.projectmanagement.controller;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.repository.EmployeeRepository;
import com.george.projectmanagement.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeServices.findAll();
        model.addAttribute("employees", employees);
        return "employee/employees";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model, HttpServletRequest request){
        // redirect an obj from another controller ProjectController
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if(flashMap != null) {
            String emailError = (String) flashMap.get("noEmployeeError");
        }
        model.addAttribute("employee", new Employee());
        return "employee/new-employee";
    }

    @PostMapping("/save")
    public String createProject(@Valid Employee employee, BindingResult bindingResult, Model model) {
        //check for errors
        if (bindingResult.hasErrors()) {
            // return goes to page
            return "employee/new-employee";
        }

        //if there are no errors, show form success screen
        employeeServices.save(employee);
        // use a redirect to prevent duplicate submissions
        // redirect goes to mapping url
        return "redirect:/employees";
    }


    // end
}
