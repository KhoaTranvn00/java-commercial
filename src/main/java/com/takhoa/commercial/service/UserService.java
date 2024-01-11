package com.takhoa.commercial.service;

import com.takhoa.commercial.config.UserInfoDetails;
import com.takhoa.commercial.entity.User;
import com.takhoa.commercial.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepository.findByUsername(username);
        return userInfo.map(UserInfoDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
