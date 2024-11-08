package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.entity.Ticket;
import com.example.SB_Week9.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    //CRUD
    TicketDto create(TicketDto ticketDto) throws Exception;
    List<TicketDto> reads();
    TicketDto read(Long ticketID) throws Exception;
    TicketDto update(Long ticketID, TicketDto ticketDto) throws Exception;
    void delete(Long ticketID) throws Exception;
}
