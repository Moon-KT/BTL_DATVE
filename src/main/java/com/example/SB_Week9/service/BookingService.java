package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.BookingRequest;
import com.example.SB_Week9.dto.BookingResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    BookingResponse bookTicket (BookingRequest bookingRequest) throws Exception;
}
