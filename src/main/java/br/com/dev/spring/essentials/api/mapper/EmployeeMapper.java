package br.com.dev.spring.essentials.api.mapper;

import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.domain.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeOut toResponse(Employee employee);
}
