package com.example.oceanx.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oceanx.entity.OtpEntry;

public interface OtpEntryRepository extends JpaRepository<OtpEntry, Long> {
    
    Optional<OtpEntry> findByPhoneNumberAndOtp(String phoneNumber, String otp);
    boolean existsByPhoneNumber(String phoneNumber);

}
