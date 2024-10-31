package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.Ticket;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.repository.UserRepository;
import com.example.SB_Week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

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
        public List<User> reads () {
            return userRepository.findAll();
    }

        public User read (Long userID) throws Exception {
            return userRepository.findById(userID).orElseThrow(() -> {
                return new Exception("Không tìm thấy người dùng có ID :" + userID);
        });
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

    @Override
    public boolean register (UserDto userDto) throws Exception {
        if(userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new Exception("Email đã tồn tại");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setGender(userDto.getGender());
        user.setBirthday(userDto.getBirthday());
        user.setRole("user");

//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User savedUser = userRepository.save(user);
        return savedUser.getUserID() != null;
    }

    @Override
    public User login (UserDto userDto) throws Exception {
        User user = userRepository.findByEmail(userDto.getEmail());
        if(user == null) {
            throw new Exception("Người dùng không tồn tại");
        }
        if(!user.getPassword().equals(userDto.getPassword())) {
            throw new Exception("Sai mật khẩu");
        }
        return user;
    }

    @Override
    public List<TicketDto> getBookingHistory(Long userID) {
        List<Ticket> tickets = userRepository.findById(userID).get().getTicketList();

        return tickets.stream().map(ticket -> {
            TicketDto ticketDto = new TicketDto();
            ticketDto.setBookingDate(ticket.getBookingDate());
            ticketDto.setPrice(ticket.getPrice());
            ticketDto.setUserID(ticket.getUser().getUserID());
            ticketDto.setPaymentID(ticket.getPayment().getPaymentID());
            ticketDto.setShowtimeID(ticket.getShowtime().getShowtimeID());
            ticketDto.setSeatID(ticket.getSeat().getSeatID());
            return ticketDto;
        }).collect(Collectors.toList());
    }
}
