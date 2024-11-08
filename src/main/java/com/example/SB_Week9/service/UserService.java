package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.BookingRequest;
import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    //CRUD
    UserDto create(UserDto userDto) throws Exception;
    List<UserDto> reads();
    UserDto read(Long userID) throws Exception;
    UserDto update(Long userID, UserDto userDto) throws Exception;
    void delete(Long userID) throws Exception;

    //Other
    List<BookingRequest> getBookingHistory(Long userID) throws Exception;
}
