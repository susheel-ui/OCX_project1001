package com.example.oceanx.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.oceanx.entity.OtpEntry;
import com.example.oceanx.repository.OtpEntryRepository;
import com.example.oceanx.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private OtpEntryRepository otpEntryRepository;

    public ResponseEntity<String> sendOtp(String phoneNumber) {
        try {
            String otp = "12345"; // In real scenario, generate random OTP and send via SMS
            OtpEntry otpEntity = new OtpEntry();
            otpEntity.setPhoneNumber(phoneNumber);
            otpEntity.setOtp(otp);
            otpEntity.setCreatedAt(LocalDateTime.now());
            otpEntryRepository.save(otpEntity);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("OTP generated and saved successfully!");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to generate OTP: " + e.getMessage());
        }
    }

    public ResponseEntity<String> verifyOtp(String phoneNumber, String otp) {
        boolean exists = otpEntryRepository.existsByPhoneNumber(phoneNumber);
        if (!exists) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Phone number does not exist");
        }
        Optional<OtpEntry> otpEntry = otpEntryRepository.findByPhoneNumberAndOtp(phoneNumber, otp);
        if (otpEntry.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("OTP verified successfully!");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid OTP!");
        }
    }
}
