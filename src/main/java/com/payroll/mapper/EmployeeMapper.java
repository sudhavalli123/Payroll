package com.payroll.mapper;

import com.payroll.dto.EmployeeDTO;
import com.payroll.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "Spring")
public interface EmployeeMapper {

    EmployeeDTO toEmployeeDTO(Employee employee);
    Employee toEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employeeList);

}
