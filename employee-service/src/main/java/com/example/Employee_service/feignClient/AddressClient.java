package com.example.Employee_service.feignClient;

import com.example.Employee_service.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="address-service",url = "http://localhost:8989/api/address-app")
public interface AddressClient {

//    @GetMapping("/address/{id}")
//    AddressResponse getAddressByEmployeeId(@PathVariable ("id") int id );

//
//    @GetMapping("/address/{employeeID}")
//   ResponseEntity<AddressResponse> getAddressEmployeeID(@PathVariable("employeeID") int id);



}
