package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.repository.UserRepository;
import com.example.SB_Week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;

        @Override
        public User create (UserDto userDto) throws Exception {
            User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setGender(userDto.getGender());
        user.setBirthday(userDto.getBirthday());
        user.setRole(userDto.getRole());
        return userRepository.save(user);
    }

        @Override
        public List<User> getAllUsers () {
        return userRepository.findAll();
    }

        public User getUserById (Long userID) throws Exception {
        return userRepository.findById(userID).orElseThrow(() -> {
            return new Exception("Không tìm thấy người dùng có ID :" + userID);
        });
    }

        @Override
        public User getUserByEmail (String email) throws Exception {
        return userRepository.findByEmail(email);
    }

        @Override
        public User update (Long userID, UserDto userDto) throws Exception {
        Optional<User> user = Optional.ofNullable(userRepository.findById(userID).orElseThrow(() -> {
            return new Exception("Not thay! ");
        }));

        user.get().setUsername(userDto.getUsername());
        user.get().setEmail(userDto.getEmail());
        user.get().setPhone(userDto.getPhone());
        user.get().setAddress(userDto.getAddress());
        user.get().setGender(userDto.getGender());
        user.get().setBirthday(userDto.getBirthday());

        return userRepository.save(user.get());
    }

        @Override
        public void delete (Long userID) throws Exception {
        Optional<User> user = Optional.ofNullable(userRepository.findById(userID).orElseThrow(() -> {
            return new Exception("Not thay! ");
        }));

        userRepository.deleteById(userID);
    }
}
