package com.takhoa.commercial.service;

import com.takhoa.commercial.config.UserInfoDetails;
import com.takhoa.commercial.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticateService {
    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails currentPrincipalName = (UserInfoDetails) authentication.getPrincipal();
        return currentPrincipalName.getId().toString();
    }
}
