package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.BookingRequest;
import com.example.SB_Week9.dto.BookingResponse;
import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.*;
import com.example.SB_Week9.repository.*;
import com.example.SB_Week9.service.BookingService;
import com.example.SB_Week9.service.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws Exception {
        User user = userRepository.findByEmail(bookingRequest.getUser().getEmail());
        if (user == null) {
            throw new Exception("User not found");
        }

        Showtime showtime = showtimeRepository.findByMovieNameAndCinemaName(
                bookingRequest.getShowtime().getMovie().getMovieName(),
                bookingRequest.getShowtime().getRoom().getCinema().getCinemaName());
        if (showtime == null) {
            throw new Exception("Showtime not found");
        }

        List<Seat> seats = seatRepository.findAllById(bookingRequest.getSeats().stream()
                .map(Seat::getSeatID)
                    .collect(Collectors.toList()));

        Promotion promotion = promotionRepository.findById(bookingRequest.getPromotion().getPromotionID()).orElseThrow(() -> new Exception("Promotion not found"));
        Double totalPrice = 0.0;

        switch (promotion.getPromotionType().name())
        {
            case "GIFT":
                totalPrice += promotion.getPrice();
                for (Seat seat : bookingRequest.getSeats()) {
                    try {
                        Seat foundSeat = seatRepository.findById(seat.getSeatID()).orElseThrow(
                                () -> new Exception("Seat not found"));
                        totalPrice += foundSeat.getSeatType().getSeatPrice();


                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case "CINEMA":
                totalPrice += promotion.getPrice()*seats.size();
                break;
        }

        totalPrice -= user.getAccumulatedPoints();

        if(totalPrice < 0) {
            user.setAccumulatedPoints(-totalPrice);
            totalPrice = 0.0;
        }
        Booking booking = Booking.builder()
                .user(user)
                .showtime(showtime)
                .booking_seats(seats.stream()
                        .map(seat -> Booking_Seat.builder()
                                .seat(seat)
                                .build())
                        .collect(Collectors.toList()))
                .totalPrice(totalPrice)
                .bookingTime(LocalDateTime.now())
                .build();

        booking.calculatePoints();
        user.setAccumulatedPoints(user.getAccumulatedPoints() + booking.getPointsEarned());
        userRepository.save(user);

        List<Ticket> tickets = new ArrayList<>();
        for (Seat seat : seats) {
            Ticket ticket = Ticket.builder()
                    .booking(booking)
                    .seat(seat)
                    .price(seat.getSeatType().getSeatPrice())
                    .ticketCode(generateTicketCode())  // Mã vé ngẫu nhiên
                    .build();
            tickets.add(ticket);
        }

        booking.setTickets(tickets);

        Booking booking1 = bookingRepository.save(booking);
        return BookingResponse.builder()
                .bookingID(booking1.getBookingID())
                .finalPrice(booking1.getTotalPrice())
                .message("Booking successful")
                .build();
    }

    private String generateTicketCode() {
        // Logic để tạo mã vé ngẫu nhiên
        return UUID.randomUUID().toString();
    }

    // Phương thức gửi vé điện tử qua email
    private void sendBookingConfirmation(User user, Booking booking) {
        String recipientEmail = user.getEmail();
        String subject = "Your E-Ticket Confirmation";
        String body = generateTicketDetails(booking);

        emailService.sendEmail(user.getEmail(), recipientEmail, subject, body);
    }

    // Phương thức tạo nội dung vé điện tử
    private String generateTicketDetails(Booking booking) {
        // Ví dụ về cách tạo thông tin vé điện tử
        return "Booking Details:\n" +
                "Movie: " + booking.getShowtime().getMovie().getMovieName() + "\n" +
                "Cinema: " + booking.getShowtime().getRoom().getCinema().getCinemaName() + "\n" +
                "Date: " + booking.getShowtime().getStartTime() + "\n" +
                "Price: " + booking.getTotalPrice() + "\n" +
                "Promotion: " + (booking.getPromotion() != null ? booking.getPromotion().getPromotionDescription() : "None") + "\n" +
                "Seats: " + booking.getBooking_seats().stream().map(Booking_Seat::getSeat).map(Seat::getSeatRow).collect(Collectors.joining(", ")) + "\n" +
                "Thank you for choosing our service!";
    }

}
