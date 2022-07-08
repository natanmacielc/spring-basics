package br.com.dev.spring.essentials.api.assembler;

import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.api.mapper.Mapper;
import br.com.dev.spring.essentials.domain.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeAssembler {

    @Autowired
    private Mapper mapper;

    public EmployeeOut toDto(Employee employee) {
        return mapper.mapObject(employee, EmployeeOut.class);
    }

    public List<EmployeeOut> toDTO(List<Employee> employeeList) {
        return mapper.mapList(employeeList, EmployeeOut.class);
    }
}
