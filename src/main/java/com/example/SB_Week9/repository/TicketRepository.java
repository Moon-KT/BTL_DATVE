package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
