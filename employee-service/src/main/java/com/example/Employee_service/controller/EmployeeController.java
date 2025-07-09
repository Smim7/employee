package com.example.Employee_service.controller;

import com.example.Employee_service.response.EmployeeResponse;
import com.example.Employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;

@GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse> getEmployeetails(@PathVariable("id") int id){
    EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);

}

}
