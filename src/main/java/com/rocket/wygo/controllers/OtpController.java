package com.rocket.wygo.controllers;

import com.rocket.wygo.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OtpController {
    @Autowired
    private OtpService otpService;

    // API để gửi OTP đến email của người dùng
    @PostMapping("/sendOTP")
    public ResponseEntity<String> sendOTP(@RequestParam String email) {
        String otp = otpService.generateOTP();
        otpService.sendOTP(email, otp);
        otpService.saveOTP(email, otp);
        return ResponseEntity.ok("OTP đã được gửi đến email của bạn.");
    }


    // API để xác thực OTP
    @PostMapping("/verifyOTP")
    public ResponseEntity<String> verifyOTP(@RequestParam String email, @RequestParam String otp) {
        if (otpService.verifyOTP(email, otp)) {
            return ResponseEntity.ok("Xác thực thành công.");
        } else {
            return ResponseEntity.badRequest().body("Mã OTP không đúng.");
        }
    }
}
