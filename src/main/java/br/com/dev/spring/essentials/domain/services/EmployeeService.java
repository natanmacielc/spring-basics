package br.com.dev.spring.essentials.domain.services;

import br.com.dev.spring.essentials.api.assembler.EmployeeAssembler;
import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.domain.entities.Employee;
import br.com.dev.spring.essentials.domain.exceptions.EmployeeNotFoundException;
import br.com.dev.spring.essentials.domain.repository.EmployeeRepository;
import br.com.dev.spring.essentials.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeAssembler assembler;

    @Autowired
    private LogRepository log;

    public List<EmployeeOut> getResourceCollection() {
        List<Employee> employeeList = repository.findAll();

        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("List is empty.");
        }

        return this.assembler.toDTO(employeeList);
    }

    public EmployeeOut getResource(Long id) {

        Optional<Employee> employee = repository.findById(id);

        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return this.assembler.toDto(employee.get());
    }

    public Employee saveResource(Employee employee) {
        employee.setRegistrationDate(LocalDate.now());
        return repository.save(employee);
    }
}
