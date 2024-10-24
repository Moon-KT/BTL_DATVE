package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(seatService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(seatService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SeatDto seatDto) throws Exception{
        return ResponseEntity.ok().body(seatService.create(seatDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody SeatDto seatDto) throws Exception{
        return ResponseEntity.ok().body(seatService.update(id, seatDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        seatService.delete(id);
        return ResponseEntity.ok("Xóa ghế thành công");
    }
}
