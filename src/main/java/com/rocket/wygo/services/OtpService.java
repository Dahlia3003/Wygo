package com.rocket.wygo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {
    @Autowired
    private JavaMailSender mailSender;

    // Khởi tạo một map để lưu mã OTP cho từng người dùng (sẽ thay bằng cơ sở dữ liệu trong môi trường thực tế)
    private Map<String, String> otpMap = new HashMap<>();

    // Tạo mã OTP
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    // Gửi mã OTP đến email của người dùng
    public void sendOTP(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Xác thực OTP");
        message.setText("Mã OTP của bạn là: " + otp);
        mailSender.send(message);
    }

    // Lưu mã OTP vào map (hoặc cơ sở dữ liệu)
    public void saveOTP(String email, String otp) {
        otpMap.put(email, otp);
    }

    // Kiểm tra mã OTP của người dùng
    public boolean verifyOTP(String email, String otp) {
        String savedOTP = otpMap.get(email);
        return savedOTP != null && savedOTP.equals(otp);
    }
}

