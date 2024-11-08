package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.BookingRequest;
import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.Booking_Seat;
import com.example.SB_Week9.entity.Seat;
import com.example.SB_Week9.entity.Showtime;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.entity.enumModel.UserRole;
import com.example.SB_Week9.repository.UserRepository;
import com.example.SB_Week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .gender(user.getGender())
                .birthday(user.getBirthday())
                .build();
    }

    @Override
    public UserDto create (UserDto userDto) throws Exception {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .address(userDto.getAddress())
                .gender(userDto.getGender())
                .birthday(userDto.getBirthday())
                .role(UserRole.admin)
                .build();
        return convertToDto(userRepository.save(user));
    }

        @Override
        public List<UserDto> reads () {
            return userRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

        public UserDto read (Long userID) throws Exception {
            return userRepository.findById(userID).map(this::convertToDto).orElseThrow(() -> {
                return new Exception("Người dùng không tồn tại");
        });
    }

        @Override
        public UserDto update (Long userID, UserDto userDto) throws Exception {
            User existingUser = userRepository.findById(userID).orElseThrow(() -> {
                return new Exception("Người dùng không tồn tại");
            });

            User updatedUser = existingUser.toBuilder()
                    .username(userDto.getUsername())
                    .email(userDto.getEmail())
                    .password(userDto.getPassword())
                    .phone(userDto.getPhone())
                    .address(userDto.getAddress())
                    .birthday(userDto.getBirthday())
                    .build();
            return convertToDto(userRepository.save(updatedUser));
    }

        @Override
        public void delete (Long userID) throws Exception {
            if(!userRepository.existsById(userID)) {
                throw new Exception("Người dùng không tồn tại");
            }
            userRepository.deleteById(userID);
    }

    @Override
    public List<BookingRequest> getBookingHistory(Long userID) throws Exception {
        User user = userRepository.findById(userID).orElseThrow(() -> {
            return new Exception("Người dùng không tồn tại");
        });

        return user.getBookings().stream().map(booking -> BookingRequest.builder()
                .showtime(convertToDto(booking.getShowtime()))
                        .seats(booking.getBooking_seats().stream()
                                .map(Booking_Seat::getSeat)
                                .collect(Collectors.toList()))
                .build())
                .collect(Collectors.toList());

    }

    private Showtime convertToDto(Showtime showtime) {
        return Showtime.builder()
                .showtimeID(showtime.getShowtimeID())
                .movie(showtime.getMovie())
                .room(showtime.getRoom())
                .startTime(showtime.getStartTime())
                .build();
    }

    private SeatDto convertToDto(Seat seat) {
        return SeatDto.builder()
                .seatNumber(seat.getSeatNumber())
                .seatRow(seat.getSeatRow())
                .build();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .userID(user.getUserID())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
    }
}
