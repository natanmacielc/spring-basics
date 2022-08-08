//package br.com.dev.spring.essentials.domain.services;
//
//import com.sun.org.apache.xpath.internal.operations.String;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//public class EmployeeService {
////
////    @Autowired
////    private EmployeeRepository repository;
////
////    @Autowired
////    private EmployeeMapper mapper;
////
////    public List<EmployeeOut> getResourceCollection() {
////        List<Employee> employeeList = repository.findAll();
////
////        if (employeeList.isEmpty()) {
////            throw new EmployeeNotFoundException("List is empty.");
////        }
////
////        return this.assembler.toDTO(employeeList);
////    }
////
////    public EmployeeOut getResource(Long id) {
////
////        Optional<Employee> employee = repository.findById(id);
////
////        if (employee.isEmpty()) {
////            throw new EmployeeNotFoundException("Employee not found");
////        }
////
////        return this.assembler.toDto(employee.get());
////    }
////
////    public Employee saveResource(Employee employee) {
////        employee.setRegistrationDate(LocalDate.now());
////        return repository.save(employee);
////    }
//
//    private String name;
//    private Integer idade;
//
//    private LocalDate data;
//}
