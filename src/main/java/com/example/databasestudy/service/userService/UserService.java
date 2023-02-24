package com.example.databasestudy.service.userService;

import com.example.databasestudy.domain.users.Users;
import com.example.databasestudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void save(Users users) {
        userRepository.save(users);
    }

    public void findById(Long userId) {
        userRepository.findById(userId);
    }

    public void delete(Users user) {
        userRepository.delete(user);
    }
}
