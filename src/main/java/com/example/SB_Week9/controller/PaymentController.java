package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.PaymentDto;
import com.example.SB_Week9.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(paymentService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(paymentService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PaymentDto paymentDto) throws Exception{
        return ResponseEntity.ok().body(paymentService.create(paymentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody PaymentDto paymentDto) throws Exception{
        return ResponseEntity.ok().body(paymentService.update(id, paymentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        paymentService.delete(id);
        return ResponseEntity.ok("Xóa thanh toán thành công");
    }
}
