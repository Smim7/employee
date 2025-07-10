package org.mim.employee.address.controller;

import org.mim.employee.address.response.AddressResponse;
import org.mim.employee.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeID}")
    public ResponseEntity<AddressResponse> getAddressEmployeeID(@PathVariable("employeeID") int id){
       AddressResponse addressResponse=null;
        addressResponse=addressService.findAddressByEmployeeeId(id);
       return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

}
