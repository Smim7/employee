package org.mim.employee.address.service;

import org.mim.employee.address.entity.Address;
import org.mim.employee.address.repository.AddressRepo;
import org.mim.employee.address.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeeId(int emloyeeId){
        Address address=addressRepo.findAddressByEmployeeId(emloyeeId);
        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;

    }
}