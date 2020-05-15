package com.example.clientdemo;

import com.example.clientdemo.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Service
@FeignClient(serviceId = "resource")
public interface FeignUserService {
    @RequestMapping(method = RequestMethod.POST, value = "/getUserName")
    ResponseEntity<String> getName(@RequestBody UserDto user);
}
