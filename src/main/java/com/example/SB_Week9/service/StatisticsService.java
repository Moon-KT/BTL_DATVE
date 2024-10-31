package com.example.SB_Week9.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface StatisticsService {
    Long getTotalTicketSold();
    Double getTotalRevenue();
    String getTopMovie();
}
