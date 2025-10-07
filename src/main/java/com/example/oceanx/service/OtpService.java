package com.example.oceanx.service;

import org.springframework.http.ResponseEntity;

public interface OtpService {

    ResponseEntity<String> sendOtp(String phoneNumber);

    ResponseEntity<String> verifyOtp(String phoneNumber, String otp);
}