package br.com.dev.spring.essentials.domain.services;

import br.com.dev.spring.essentials.api.controller.AbstractMockMvc;
import br.com.dev.spring.essentials.api.controller.fixture.EmployeeFixture;
import br.com.dev.spring.essentials.api.dto.EmployeeOut;
import br.com.dev.spring.essentials.domain.entities.Employee;
import br.com.dev.spring.essentials.domain.exceptions.EmployeeNotFoundException;
import br.com.dev.spring.essentials.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest extends AbstractMockMvc {

    @Autowired
    EmployeeService service;

    @MockBean
    EmployeeRepository repository;

    @Test
    public void testGetResourceCollectionSuccess() {
        when(repository.findAll()).thenReturn(EmployeeFixture.generateEmployeeList());

        List<EmployeeOut> employeeOutList = service.getResourceCollection();

        this.verifyAssertionsList(employeeOutList, 1L, 0);
        this.verifyAssertionsList(employeeOutList, 2L, 1);
    }

    @Test
    public void testGetResourceCollectionWithException() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> {
            service.getResourceCollection();
        });
    }

    @Test
    public void testGetResourceSuccess() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(EmployeeFixture.generateEmployee(1L)));

        EmployeeOut employeeOut = service.getResource(anyLong());

        this.verifyAssertions(employeeOut, 1L);
    }

    @Test
    public void testGetResourceWithException() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EmployeeNotFoundException.class, () -> {
            service.getResource(anyLong());
        });
    }

    private void verifyAssertionsList(List<EmployeeOut> employeeOutList, Long value, Integer position) {
        assertEquals(value, employeeOutList.get(position).getEmployeeCode());
        assertEquals(value.toString(), employeeOutList.get(position).getName());
        assertEquals(value.intValue(), employeeOutList.get(position).getAge());
        assertEquals(LocalDate.now(), employeeOutList.get(position).getRegistrationDate());
    }

    private void verifyAssertions(EmployeeOut employeeOut, Long value) {
        assertEquals(value, employeeOut.getEmployeeCode());
        assertEquals(value.toString(), employeeOut.getName());
        assertEquals(value.intValue(), employeeOut.getAge());
        assertEquals(LocalDate.now(), employeeOut.getRegistrationDate());
    }


}
