package com.example.Employee_service.confiquration;

import com.example.Employee_service.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfi {
    @Value("${addressservice.base.url}")
    private String addressBaseURL;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//   }
    @Bean
    public WebClient webClient(){
       return WebClient
               .builder()
               .baseUrl(addressBaseURL)
               .build();
    }


}
