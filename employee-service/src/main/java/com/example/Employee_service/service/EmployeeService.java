package com.example.Employee_service.service;

import com.example.Employee_service.entity.Employee;
import com.example.Employee_service.repository.EmployeeRepo;
import com.example.Employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponse getEmployeeById(int id){
        Employee employee= employeeRepo.findById(id).get();
       EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);

//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodgroup(employee.getBloodgroup());
//        employeeResponse.setEmail(employee.getEmail());

        return employeeResponse;
    }
}
