package com.payroll.service;


import com.payroll.dto.EmployeeDTO;
import com.payroll.entity.Employee;
import com.payroll.exception.ResourceNotFoundException;
import com.payroll.mapper.EmployeeMapper;
import com.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;


    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDTO createdEmployeeDTO = employeeMapper.toEmployeeDTO(createdEmployee);
        return createdEmployeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = employeeMapper.toEmployeeDTOList(employeeList);
        return employeeDTOList;
    }

    public EmployeeDTO getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDTO employeeDTO = employeeMapper.toEmployeeDTO(employee.get());
        return employeeDTO;

    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO)
    {
        int empId = employeeDTO.getEmpId();
        if(!employeeRepository.existsById(empId))
               throw  new ResourceNotFoundException("Employee", "Employee ID", empId);
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        //employee.setId(empId);
        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDTO createdEmployeeDTO = employeeMapper.toEmployeeDTO(createdEmployee);
        return createdEmployeeDTO;

    }

    public void deleteEmployee(int empId){
        if(!employeeRepository.existsById(empId))
            throw new ResourceNotFoundException("Employee", "Employee ID", empId);
        employeeRepository.deleteById(empId);
    }
}
