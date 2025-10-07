package com.example.oceanx.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface OtpService {

    ResponseEntity<String> sendOtp(Map<String, String> responsephoneNumber);

    ResponseEntity<String> verifyOtp(Map<String, String> verifyBody);

    ResponseEntity<String> registerUser(Map<String, String> registerBody);
}