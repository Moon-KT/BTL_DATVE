package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.entity.*;
import com.example.SB_Week9.service.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Qualifier("comboOfferService")

    @PostMapping("/book")
    public ResponseEntity<?> bookTicket(@RequestBody TicketDto ticketDto,
                                        @RequestBody List<ComboOffer> comboOffers,
                                        @RequestBody List<Seat> seats,
                                        @RequestBody List<Promotion> promotions) {
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

            Seat seat = seatService.read(ticketDto.getSeatID());
            if(seat.getStatus().equals("Available")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Ghế " + seat.getSeatRow() + "-" + seat.getSeatNumber() + " đã được đặt");
            }

            // Tạo đối tượng Ticket từ TicketDto
            Ticket ticket = new Ticket();
            ticket.setBookingDate(LocalDateTime.now()); // Set thời gian đặt vé
            ticket.setUser(user); // Set user từ đối tượng đã xác thực
            ticket.setShowtime(showtime); // Set showtime
            ticket.setSeat(seat); // Set seat

            // Tính toán giá vé
            double totalPrice = calculateTotalPrice(comboOffers, seats, promotions);
            ticket.setPrice(totalPrice);

            // Lưu vé vào cơ sở dữ liệu
            Ticket savedTicket = ticketService.create(ticketDto);

            // Xuất mã QR (tùy chọn)
            String qrCode = generateQRCode(savedTicket); // Hàm tạo mã QR từ thông tin vé

            return ResponseEntity.ok("Đặt vé thành công! Mã QR của bạn: " + qrCode);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đặt vé không thành công");
        }
    }
    private double calculateTotalPrice(List<ComboOffer> comboOffers, List<Seat> seats, List<Promotion> promotions) {
        double totalPrice = 0.0;
        for (Seat seat : seats) {
            totalPrice += seat.getSeatType().getSeatPrice();
        }
        for (ComboOffer comboOffer : comboOffers) {
            totalPrice += comboOffer.getPrice();
        }
        double totalDiscount = promotions.stream().mapToDouble(Promotion::getDiscount).sum();
        return totalPrice * (1 - totalDiscount / 100);
    }

    private String generateQRCode(Ticket ticket) throws WriterException, IOException {
        // Tạo chuỗi thông tin cho mã QR
        String qrData = "Thông tin vé:\n" +
                "User: " + ticket.getUser().getUsername() + "\n" +
                "Showtime: " + ticket.getShowtime().getStartTime() + "\n" +
                "Seat: " + ticket.getSeat().getSeatRow() + "-" + ticket.getSeat().getSeatNumber() + "\n" +
                "Price: " + ticket.getPrice();

        String directory = "image"; // Thay đổi đường dẫn thành thư mục của bạn
        String filename = "Ve_" + ticket.getUser().getUsername() + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
        String path = directory + "/" + filename;

        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

        createQR(qrData, path, charset, hashMap, 200, 200);
        return path;
    }

    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
            throws WriterException, IOException
    {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }
}

