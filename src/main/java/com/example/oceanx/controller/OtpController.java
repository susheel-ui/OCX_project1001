package com.example.oceanx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.oceanx.service.OtpService;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody String phoneNumber) {
    System.out.println("inside controller - sendOtp");
    return otpService.sendOtp(phoneNumber);
    }


    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody String phoneNumber, @RequestBody String otp) {
        return otpService.verifyOtp(phoneNumber, otp);
    }

    // @PostMapping('/register')
    // public ResponseEntity<String> registerUser(@RequestParam String phoneNumber, @RequestParam String otp) {
    //     return otpService.registerUser(phoneNumber, otp);
    }