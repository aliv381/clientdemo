package com.example.clientdemo;

import com.example.clientdemo.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public static final String ERROR_MESSAGE="Error on resource server side";

    @Autowired
    FeignUserService fs;

    @GetMapping("/hello")
    public ResponseEntity<String> name(){

        ResponseEntity<String> responseFromResource = fs.getName(new UserDto("User Name",2));

        if(HttpStatus.OK.equals(responseFromResource.getStatusCode())){
            return responseFromResource;
        } else {
            return new ResponseEntity<String>(ERROR_MESSAGE,HttpStatus.BAD_REQUEST);
        }

    }
}
