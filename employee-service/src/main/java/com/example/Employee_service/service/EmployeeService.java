package com.example.Employee_service.service;

import com.example.Employee_service.entity.Employee;
import com.example.Employee_service.feignClient.AddressClient;
import com.example.Employee_service.repository.EmployeeRepo;
import com.example.Employee_service.response.AddressResponse;
import com.example.Employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private WebClient webClient;

//    @Autowired
//   private AddressClient addressClient;

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


//    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseURL,
//                           RestTemplateBuilder builder) {
//        this.restTemplate=builder
//                .rootUri(addressBaseURL)
//                .build();
//    }

    public EmployeeResponse getEmployeeById(int id){
        Employee employee= employeeRepo.findById(id).get();
       EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);


        AddressResponse addressResponse=callToAddressUsingRestTemplate(id);


//          ResponseEntity<AddressResponse> addressResponseResponseEntity=addressClient.getAddressEmployeeID(id);
//        AddressResponse addressResponse=addressResponseResponseEntity.getBody();
//                    =webClient
//                    .get()
//                    .uri("/address/"+id)
//                    .retrieve().bodyToMono(AddressResponse.class)
//                    .block();

       employeeResponse.setAddressResponse(addressResponse);

//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodgroup(employee.getBloodgroup());
//        employeeResponse.setEmail(employee.getEmail());

        return employeeResponse;
    }
    private  AddressResponse callToAddressUsingRestTemplate(int id){
      //  ServiceInstance serviceInstance = null;
// ////      List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
    //    System.out.println("Instances " + instances);
//        if (instances != null || !instances.isEmpty()) {
         // ///   serviceInstance = instances.get(0);
//        } else {
//            System.out.println("No ServiceInstance found");
//        }
       // //// String uri=serviceInstance.getUri().toString() + "/api/address-app";
    // ////    System.out.println("uri>>>>>>>>"+uri);

        ServiceInstance serviceInstance1 = loadBalancerClient.choose("address-service");
        String uri=serviceInstance1.getUri().toString();
        String contextRoot=serviceInstance1.getMetadata().get("confiqPath");

      return   restTemplate.getForObject(uri+contextRoot+"/address/{id}",AddressResponse.class,id);
    }
}
