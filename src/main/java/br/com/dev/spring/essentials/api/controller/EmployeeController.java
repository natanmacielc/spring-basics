//package br.com.dev.spring.essentials.api.controller;
//
//import br.com.dev.spring.essentials.api.dto.EmployeeOut;
//import br.com.dev.spring.essentials.domain.entities.Employee;
//import br.com.dev.spring.essentials.domain.services.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "v1/employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService service;
//
//    @GetMapping
//    public List<EmployeeOut> exposeResourceCollection() {
//
//        return this.service.getResourceCollection();
//    }
//
//    @GetMapping(value = "/{employeeCode}")
//    public EmployeeOut exposeResource(@PathVariable Long employeeCode) {
//
//        return this.service.getResource(employeeCode);
//    }
//
//    @PostMapping
//    public Employee saveEmployee(@RequestBody Employee employee) {
//        this.service.saveResource(employee);
//        return employee;
//    }
//
//}
