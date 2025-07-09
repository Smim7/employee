package com.example.Employee_service.confiquration;

import com.example.Employee_service.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAppConfi {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
