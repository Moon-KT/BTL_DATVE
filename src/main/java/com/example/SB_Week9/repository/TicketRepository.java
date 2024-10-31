package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Ticket;
import com.example.SB_Week9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
