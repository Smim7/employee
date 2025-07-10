package org.mim.employee.address.confiquration;

import org.mim.employee.address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Addressconfi {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
