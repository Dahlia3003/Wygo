package com.rocket.wygo.services;

import com.rocket.wygo.exceptions.UserAlreadyExistsException;
import com.rocket.wygo.exceptions.UserNotFoundException;
import com.rocket.wygo.models.ReportUser;
import com.rocket.wygo.models.User;
import com.rocket.wygo.repositories.ReportUserRepository;
import com.rocket.wygo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ReportUserService {
    @Autowired
    private ReportUserRepository reportUserRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void newReportUser(String authorUsername, String targetUsername, String reason) throws UserAlreadyExistsException {
        User authorObject = userRepository.findByUsername(authorUsername);
        User targetObject = userRepository.findByUsername(targetUsername);
        if (targetObject == null || authorObject == null) {
            throw new UserNotFoundException("Username không tìm thấy");
        }

        ReportUser reportUser = new ReportUser(authorObject, targetObject, reason);
        reportUserRepository.save(reportUser);
    }
}
