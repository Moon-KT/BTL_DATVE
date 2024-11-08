package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.entity.Booking;
import com.example.SB_Week9.entity.Ticket;
import com.example.SB_Week9.repository.BookingRepository;
import com.example.SB_Week9.repository.MovieRepository;
import com.example.SB_Week9.repository.TicketRepository;
import com.example.SB_Week9.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Long getTotalTicketSold() {
        return ticketRepository.count();
    }

    @Override
    public Double getTotalRevenue() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().mapToDouble(Ticket::getPrice).sum();
    }

    @Override
    public String getTopMovie() {
        List<Booking> bookings = bookingRepository.findAll();
        Map<String, Long> movieBookingCount = bookings.stream()
                .collect(Collectors.groupingBy(
                        b -> b.getShowtime().getMovie().getMovieName(),
                        Collectors.counting()
                ));
        return movieBookingCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No movies found");
    }
}
