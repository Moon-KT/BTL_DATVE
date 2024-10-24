package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.entity.Seat;
import com.example.SB_Week9.entity.Showtime;
import com.example.SB_Week9.entity.Ticket;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.service.SeatService;
import com.example.SB_Week9.service.ShowtimeService;
import com.example.SB_Week9.service.TicketService;
import com.example.SB_Week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ShowtimeService showtimeService;
    @Autowired
    private UserService userService;

    @Autowired
    private SeatService seatService;

    @PostMapping("/book")
    public ResponseEntity<?> bookTicket(@RequestBody TicketDto ticketDto) {
        try {
            // Xác thực người dùng
            User user = userService.read(ticketDto.getUserID());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Người dùng không hợp lệ");
            }

            // Kiểm tra thông tin showtime
            Showtime showtime = showtimeService.read(ticketDto.getShowtimeID());
            if (showtime == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Showtime không hợp lệ");
            }

            // Kiểm tra tình trạng ghế
            Seat seat = seatService.read(ticketDto.getSeatID());
            if(seat.getStatus().equals("Available")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Ghế đã được đặt");
            }

            // Lưu vé vào cơ sở dữ liệu
            Ticket ticket = ticketService.create(ticketDto);

            // Xuất mã QR (tùy chọn)
            String qrCode = generateQRCode(ticket); // Hàm tạo mã QR từ thông tin vé

            return ResponseEntity.ok(ticket); // Trả về vé và mã QR
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đặt vé không thành công");
        }
    }

    private Double calculatePrice(TicketDto ticketDto) {
        // Logic tính giá dựa vào vé, combo và khuyến mãi
        return 100.0; // Ví dụ giá cố định, có thể điều chỉnh
    }

    private String generateQRCode(Ticket ticket) {
        // Logic tạo mã QR từ thông tin vé
        return "qr-code-string"; // Trả về chuỗi mã QR
    }
}

