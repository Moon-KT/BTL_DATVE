package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.SeatTypeDto;
import com.example.SB_Week9.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seatTypes")
public class SeatTypeController {
    @Autowired
    private SeatTypeService seatTypeService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(seatTypeService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(seatTypeService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SeatTypeDto seatTypeDto) throws Exception{
        return ResponseEntity.ok().body(seatTypeService.create(seatTypeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody SeatTypeDto seatTypeDto) throws Exception{
        return ResponseEntity.ok().body(seatTypeService.update(id, seatTypeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        seatTypeService.delete(id);
        return ResponseEntity.ok("Xóa loại ghế thành công");
    }
}
