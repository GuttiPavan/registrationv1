package com.api.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(1, "mike"),
                new Employee(2, "stallin")

        );
        List<EmployeeDto> dtos = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());

        //OR

        // List<EmployeeDto> dtos = employees.stream().map(A::mapToDto).collect(Collectors.toList());
    }

    static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        System.out.println(dto);
        return dto;
    }
}

