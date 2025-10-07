package com.example.oceanx.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oceanx.service.OtpService;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> responsephoneNumber) {
    return otpService.sendOtp(responsephoneNumber);
    }


    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> verifyBody) {
        return otpService.verifyOtp(verifyBody);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> registerBody) {
        return otpService.registerUser(registerBody);
    }
}