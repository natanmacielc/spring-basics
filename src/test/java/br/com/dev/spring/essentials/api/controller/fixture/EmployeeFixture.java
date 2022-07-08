package br.com.dev.spring.essentials.api.controller.fixture;

import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.domain.entities.Employee;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFixture {

    static final LocalDate REGISTRATION_DATE = LocalDate.now();

    public static Employee generateEmployee(Long index) {
        return Employee.builder()
                .employeeCode(index)
                .age(index.intValue())
                .name(index.toString())
                .registrationDate(REGISTRATION_DATE)
                .build();
    }

    public static List<Employee> generateEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(generateEmployee(1L));
        employeeList.add(generateEmployee(2L));
        return employeeList;
    }

    public static EmployeeOut generateEmployeeOut(Long index) {
        return EmployeeOut.builder()
                .employeeCode(index)
                .age(index.intValue())
                .name(index.toString())
                .registrationDate(REGISTRATION_DATE)
                .build();
    }

    public static List<EmployeeOut> generateEmployeeOutList() {
        List<EmployeeOut> employeeOutList = new ArrayList<>();
        employeeOutList.add(generateEmployeeOut(1L));
        employeeOutList.add(generateEmployeeOut(2L));
        return employeeOutList;
    }
}
