package com.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int empId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String deptId;
    private Date dob;
    private int salary;
}
