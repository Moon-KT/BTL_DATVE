package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.entity.*;
import com.example.SB_Week9.repository.*;
import com.example.SB_Week9.service.TicketService;
import com.example.SB_Week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatRepository seatRepository;

    private TicketDto convertToDto(Ticket ticket) {
        return TicketDto.builder()
                .price(ticket.getPrice())
                .ticketCode(ticket.getTicketCode())
                .seatID(ticket.getSeat().getSeatID())
                .build();
    }
    @Override
    public TicketDto create(TicketDto ticketDto) throws Exception {
        // Lấy thông tin từ TicketDto và kiểm tra sự tồn tại của các thành phần liên quan
        Optional<Seat> seat = Optional.ofNullable(seatRepository.findById(ticketDto.getSeatID())
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + ticketDto.getSeatID())));

        return convertToDto(ticketRepository.save(Ticket.builder()
                .price(ticketDto.getPrice())
                .ticketCode(ticketDto.getTicketCode())
                .seat(seat.get())
                .build()));
    }

    @Override
    public List<TicketDto> reads() {
        return ticketRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TicketDto read(Long ticketID) throws Exception {
        return ticketRepository.findById(ticketID).map(this::convertToDto).orElseThrow(() -> {
            return new Exception("Không tìm thấy vé có ID: " + ticketID);
        });
    }

    @Override
    public TicketDto update(Long ticketID, TicketDto ticketDto) throws Exception {
        Optional<Seat> seat = Optional.ofNullable(seatRepository.findById(ticketDto.getSeatID())
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + ticketDto.getSeatID())));

        Ticket ticket = Optional.ofNullable(ticketRepository.findById(ticketID).orElseThrow(() -> {
            return new Exception("Không tìm thấy vé có ID: " + ticketID);
        })).get();

        // Cập nhật các thuộc tính từ TicketDto
         ticket.toBuilder()
                .price(ticketDto.getPrice())
                .ticketCode(ticketDto.getTicketCode())
                .seat(seat.get())
                .build();

        return convertToDto(ticketRepository.save(ticket));
    }

    @Override
    public void delete(Long ticketID) throws Exception {
        if (!ticketRepository.existsById(ticketID)) {
            throw new Exception("Không tìm thấy vé có ID: " + ticketID);
        }
        ticketRepository.deleteById(ticketID);
    }
}
