package com.example.frontservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestService {

    @Value("${backServiceUrl}")
    String backServiceUrl;

    @GetMapping("/")
    public String method(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String s = restTemplate.getForObject(backServiceUrl, String.class);
            return s + " + Front";
        }catch (Exception e){
            return e.getLocalizedMessage();
        }
    }
}
