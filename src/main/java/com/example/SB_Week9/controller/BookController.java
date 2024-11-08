package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.BookingRequest;
import com.example.SB_Week9.dto.BookingResponse;
import com.example.SB_Week9.entity.Booking;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.service.BookingService;
import com.example.SB_Week9.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookingService bookingService;

    //private final EmailService emailService;
    @Autowired
    public BookController(BookingService bookingService) {
        this.bookingService = bookingService;
        //this.emailService = emailService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody BookingRequest bookingRequestDto) {
        try {
            BookingResponse bookingResponse = bookingService.bookTicket(bookingRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Booking created successfully with ID: " + bookingResponse.getBookingID());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating booking: " + e.getMessage());
        }
    }
//
//    @PostMapping("/confirm-payment/{bookingId}")
//    public ResponseEntity<String> confirmPayment(@PathVariable Long bookingId) {
//        try {
//            Booking booking = bookingService.confirmPayment(bookingId);
//            if (booking != null) {
//                User user = booking.getUser();
//                emailService.sendEmail(
//                        user.getEmail(),
//                        user.getEmail(),
//                        "Your E-Ticket Confirmation",
//                        generateTicketDetails(booking)
//                );
//                return ResponseEntity.ok("Payment confirmed and e-ticket sent to email: " + user.getEmail());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found.");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error confirming payment: " + e.getMessage());
//        }
//    }


}
