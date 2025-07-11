package com.example.Employee_service.service;

import com.example.Employee_service.entity.Employee;
import com.example.Employee_service.repository.EmployeeRepo;
import com.example.Employee_service.response.AddressResponse;
import com.example.Employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    private RestTemplate restTemplate;

//    @Value("${addressservice.base.url}")
//    private String addressBaseURL;

    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseURL,
                           RestTemplateBuilder builder) {
        this.restTemplate=builder
                .rootUri(addressBaseURL)
                .build();
    }

    public EmployeeResponse getEmployeeById(int id){
        Employee employee= employeeRepo.findById(id).get();
       EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);
     AddressResponse addressResponse
            = restTemplate.getForObject(
             "/address/{id}",AddressResponse.class,id);
       employeeResponse.setAddressResponse(addressResponse);

//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodgroup(employee.getBloodgroup());
//        employeeResponse.setEmail(employee.getEmail());

        return employeeResponse;
    }
}
