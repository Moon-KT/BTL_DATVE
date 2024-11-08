//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.*;
//import com.example.SB_Week9.entity.*;
//import com.example.SB_Week9.exception.*;
//import com.example.SB_Week9.service.*;
//import com.google.zxing.*;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//    @Autowired
//    private TicketService ticketService;
//
//    @Autowired
//    private ShowtimeService showtimeService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SeatService seatService;
//
//    @Autowired
//    private ComboOfferService comboOfferService;
//
//    @Autowired
//    private PromotionService promotionService;
//
//    @PostMapping("/book")
//    public ResponseEntity<?> bookTicket(@RequestBody BookingRequest bookingRequest) throws Exception {
//        List<SeatDto> actualSeats = new ArrayList<>();
//        for (SeatDto seat : bookingRequest.getSeats()) {
//            Seat actualSeat = seatService.read(seat.getSeatRow(), seat.getSeatNumber());
//            if (actualSeat == null) {
//                throw new Exception("Ghế không hợp lệ");
//            }
//            if (!actualSeat.getStatus().equals("Available")) {
//                throw new Exception("Ghế " + actualSeat.getSeatRow() + "-" + actualSeat.getSeatNumber() + " đã được đặt");
//            }
//            actualSeats.add(convertToDTO(actualSeat));
//        }
//
//        for (ComboOfferDto comboOffer : bookingRequest.getComboOffers()) {
//            ComboOfferDto actualComboOffer = comboOfferService.read(comboOffer.getComboID());
//            if (actualComboOffer == null) {
//                throw new InvalidComboOfferException("Combo không hợp lệ");
//            }
//            actualComboOffers.add(actualComboOffer);
//        }
//
//        for (PromotionDto promotion : bookingRequest.getPromotions()) {
//            PromotionDto actualPromotion = promotionService.read(promotion.getPromotionID());
//            if (actualPromotion == null) {
//                throw new InvalidPromotionException("Khuyến mãi không hợp lệ");
//            }
//            actualPromotions.add(actualPromotion);
//        }
//
//        UserDto user = userService.read(bookingRequest.getTicketDto().getUserID());
//        if (user == null) {
//            throw new Exception("Người dùng không hợp lệ");
//        }
//
//        ShowtimeDto showtime = showtimeService.read(bookingRequest.getTicketDto().getShowtimeID());
//        if (showtime == null) {
//            throw new Exception("Showtime không hợp lệ");
//        }
//
//        List<String> qrCodes = new ArrayList<>();  // Store QR codes for each ticket
//
//        for (SeatDto seat : actualSeats) {
//            // Create Ticket object for each seat
//            TicketDto ticketDto = new TicketDto();
//            ticketDto.setBookingDate(LocalDateTime.now());
//            ticketDto.setUserID(user.getUserID());
//            ticketDto.setShowtimeID(showtime.getShowtimeID());
//            ticketDto.setSeatID(seat.getSeatID());
//
//            // Calculate total price for the ticket
//            double totalPrice = calculateTotalPrice(actualComboOffers, List.of(seat), actualPromotions);
//            ticketDto.setPrice(totalPrice);
//
//            // Save the ticket in the database
//            TicketDto savedTicket = ticketService.create(ticketDto);
//
//            // Generate QR code for each ticket
//            String qrCode = generateQRCode(savedTicket);
//            qrCodes.add(qrCode);
//        }
//
//        return ResponseEntity.ok("Đặt vé thành công! Mã QR của bạn: " + qrCodes);
//    }
//
//    private SeatDto convertToDTO(Seat actualSeat) {
//        return SeatDto.builder()
//                .seatRow(actualSeat.getSeatRow())
//                .seatNumber(actualSeat.getSeatNumber())
//                .seatType(actualSeat.getSeatType())
//                .status(actualSeat.getStatus())
//                .build();
//    }
//
//    private double calculateTotalPrice(List<ComboOfferDto> comboOffers, List<SeatDto> seats, List<PromotionDto> promotions) {
//        double totalPrice = 0.0;
//        for (SeatDto seat : seats) {
//            totalPrice += seat.getSeatType().getSeatPrice();
//        }
//        for (ComboOfferDto comboOffer : comboOffers) {
//            totalPrice += comboOffer.getPrice();
//        }
//        double totalDiscount = promotions.stream().mapToDouble(PromotionDto::getDiscount).sum();
//        return totalPrice * (1 - totalDiscount / 100);
//    }
//
//    private String generateQRCode(TicketDto ticket) throws WriterException, IOException {
//        // Tạo chuỗi thông tin cho mã QR
//        String qrData = "Thông tin vé:\n" +
//                "User: " + ticket.getUserID() + "\n" +
//                "Showtime: " + ticket.getShowtimeID() + "\n" +
//                "Seat: " + ticket.getSeatID() + "\n" +
//                "Price: " + ticket.getPrice();
//
//        String directory = "image"; // Thay đổi đường dẫn thành thư mục của bạn
//        String filename = "Ve_" + ticket.getUserID() + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
//        String path = directory + "/" + filename;
//
//        String charset = "UTF-8";
//
//        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
//        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//        createQR(qrData, path, charset, hashMap, 200, 200);
//        return path;
//    }
//
//    public static void createQR(String data, String path, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap, int height, int width)
//            throws WriterException, IOException {
//        BitMatrix matrix = new MultiFormatWriter().encode(
//                new String(data.getBytes(charset), charset),
//                BarcodeFormat.QR_CODE, width, height);
//
//        MatrixToImageWriter.writeToFile(
//                matrix,
//                path.substring(path.lastIndexOf('.') + 1),
//                new File(path));
//    }
//}