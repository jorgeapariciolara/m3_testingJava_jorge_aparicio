package com.example.demo.service.junit;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorServiceTest {

    EmployeeService service;

    @BeforeEach
    void setUp(){
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        service = new EmployeeServiceImpl(repository);
    }

    @DisplayName("Calcular salario de un empleado")
    @Test
    void calculateSalaryOKTest() {
        Employee emp1 = new Employee(1L, "Emp 1", 30);
        IRPFCalculator irpfCalculator = new IRPFCalculator();
        IVACalculator ivaCalculator = new IVACalculator();
        SalaryCalculatorService service = new SalaryCalculatorService(irpfCalculator,ivaCalculator);
        double result = service.calculateSalary(emp1);
        assertNotNull(result);
        assertEquals(45919.50,result);
    }

}
