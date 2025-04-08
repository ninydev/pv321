package org.itstep.chat.services;

import org.itstep.chat.mappers.UserMapper;
import org.itstep.chat.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.itstep.chat.entities.UserModel;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository
                       ,PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        // this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserModel save(UserModel user) {

        // Проверка на дубликаты
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already taken");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already registered");
        }

        logger.info("Saving user: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
        // UserMapper.INSTANCE.mapUserModelToUserDetails(userRepository.findByUsername(username));
    }
}
