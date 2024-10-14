package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User create(UserDto userDto) throws Exception;
    List<User> getAllUsers();
    User getUserById(Long userID) throws Exception;
    User getUserByEmail(String email) throws Exception;
    User update(Long userID, UserDto userDto) throws Exception;
    void delete(Long userID) throws Exception;
}
