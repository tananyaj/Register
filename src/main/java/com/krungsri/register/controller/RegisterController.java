package com.krungsri.register.controller;

import com.krungsri.register.exception.ClientException;
import com.krungsri.register.model.AddUserRequest;
import com.krungsri.register.model.GetUserRequest;
import com.krungsri.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
@Slf4j
@RestController
@RequestMapping(path = "api/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/addUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> addUser(@RequestBody AddUserRequest request, @RequestHeader("Username") String username) throws ClientException, ParseException {
        log.info("Start Get addUser");
        registerService.addUser(request,username);
        return ResponseEntity.created(null).build();
    }
    @PostMapping(value = "/getUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUser(@RequestBody GetUserRequest request, @RequestHeader("Username") String username) throws ParseException {
        log.info("Start Get getUser");
        return  ResponseEntity.ok(registerService.getUser(request,username));
    }
}
