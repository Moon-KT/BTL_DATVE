package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.entity.*;
import com.example.SB_Week9.repository.*;
import com.example.SB_Week9.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Ticket create(TicketDto ticketDto) throws Exception {
        // Lấy thông tin từ TicketDto và kiểm tra sự tồn tại của các thành phần liên quan
        Optional<User> user = Optional.ofNullable( userRepository.findById(ticketDto.getUserID())
                .orElseThrow(() -> new Exception("Không tìm thấy người dùng có ID: " + ticketDto.getUserID())));

        Optional<Payment> payment = Optional.ofNullable( paymentRepository.findById(ticketDto.getPaymentID())
                .orElseThrow(() -> new Exception("Không tìm thấy thông tin thanh toán có ID: " + ticketDto.getPaymentID())));

        Optional<Showtime> showtime = Optional.ofNullable( showtimeRepository.findById(ticketDto.getShowtimeID())
                .orElseThrow(() -> new Exception("Không tìm thấy suất chiếu có ID: " + ticketDto.getShowtimeID())));

        Optional<Seat> seat = Optional.ofNullable( seatRepository.findById(ticketDto.getSeatID())
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + ticketDto.getSeatID())));

        // Tạo đối tượng Ticket
        Ticket ticket = new Ticket();
        ticket.setBookingDate(ticketDto.getBookingDate());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setUser(user.get());  // Gán thông tin người dùng
        ticket.setPayment(payment.get());  // Gán thông tin thanh toán
        ticket.setShowtime(showtime.get());  // Gán suất chiếu
        ticket.setSeat(seat.get());  // Gán ghế ngồi

        // Lưu vào cơ sở dữ liệu
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> reads() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket read(Long ticketID) throws Exception {
        return ticketRepository.findById(ticketID).orElseThrow(() -> {
            return new Exception("Không tìm thấy vé có ID: " + ticketID);
        });
    }

    @Override
    public Ticket update(Long ticketID, TicketDto ticketDto) throws Exception {
        Optional<User> user = Optional.ofNullable( userRepository.findById(ticketDto.getUserID())
                .orElseThrow(() -> new Exception("Không tìm thấy người dùng có ID: " + ticketDto.getUserID())));

        Optional<Payment> payment = Optional.ofNullable( paymentRepository.findById(ticketDto.getPaymentID())
                .orElseThrow(() -> new Exception("Không tìm thấy thông tin thanh toán có ID: " + ticketDto.getPaymentID())));

        Optional<Showtime> showtime = Optional.ofNullable( showtimeRepository.findById(ticketDto.getShowtimeID())
                .orElseThrow(() -> new Exception("Không tìm thấy suất chiếu có ID: " + ticketDto.getShowtimeID())));

        Optional<Seat> seat = Optional.ofNullable( seatRepository.findById(ticketDto.getSeatID())
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + ticketDto.getSeatID())));


        Optional<Ticket> ticket = Optional.ofNullable(ticketRepository.findById(ticketID).orElseThrow(() -> {
            return new Exception("Không tìm thấy vé có ID: " + ticketID);
        }));

        // Cập nhật các thuộc tính từ TicketDto
        ticket.get().setBookingDate(ticketDto.getBookingDate());
        ticket.get().setPrice(ticketDto.getPrice());
        ticket.get().setUser(user.get());
        ticket.get().setPayment(payment.get());
        ticket.get().setShowtime(showtime.get());
        ticket.get().setSeat(seat.get());

        return ticket.get();
    }

    @Override
    public void delete(Long ticketID) throws Exception {
        Optional<Ticket> ticket = Optional.ofNullable(ticketRepository.findById(ticketID).orElseThrow(() -> {
            return new Exception("Không tìm thấy vé có ID: " + ticketID);
        }));

        ticketRepository.deleteById(ticketID);
    }
}
