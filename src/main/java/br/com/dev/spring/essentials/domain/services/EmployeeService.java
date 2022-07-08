package br.com.dev.spring.essentials.domain.services;

import br.com.dev.spring.essentials.api.assembler.EmployeeAssembler;
import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.domain.entities.Employee;
import br.com.dev.spring.essentials.domain.entities.Log;
import br.com.dev.spring.essentials.domain.exceptions.EmployeeNotFoundException;
import br.com.dev.spring.essentials.domain.repository.EmployeeRepository;
import br.com.dev.spring.essentials.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Log starting = this.logger();
        starting.setLog(String.format("Starting [EmployeeService] getResourceCollection %s", starting.getTime()));
        log.save(starting);
        List<Employee> employeeList = repository.findAll();

        if (employeeList.isEmpty()) {
            Log exception = this.logger();
            starting.setLog(String.format("List is Empty", starting.getTime()));
            log.save(exception);
            throw new EmployeeNotFoundException("List is empty.");
        }

        Log success = this.logger();
        starting.setLog(String.format("Success [EmployeeService] getResourceCollection %s", starting.getTime()));
        log.save(success);
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

    private Log logger() {
        Log log = new Log();
        log.setTime(LocalDateTime.now());
        return log;
    }

}
