package com.example.SB_Week9.controller;

import com.example.SB_Week9.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/total-ticket-sold")
    public Long getTotalTicketSold() {
        return statisticsService.getTotalTicketSold();
    }

    @GetMapping("/total-revenue")
    public Double getTotalRevenue() {
        return statisticsService.getTotalRevenue();
    }

    @GetMapping("/top-movie")
    public String getTopMovie() {
        return statisticsService.getTopMovie();
    }
}
