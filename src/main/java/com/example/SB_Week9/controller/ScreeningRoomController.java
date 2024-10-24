package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.ScreeningRoomDto;
import com.example.SB_Week9.service.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/screening-rooms")
public class ScreeningRoomController {
    @Autowired
    private ScreeningRoomService screeningRoomService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(screeningRoomService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(screeningRoomService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ScreeningRoomDto screeningRoomDto) throws Exception{
        return ResponseEntity.ok().body(screeningRoomService.create(screeningRoomDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody ScreeningRoomDto screeningRoomDto) throws Exception{
        return ResponseEntity.ok().body(screeningRoomService.update(id, screeningRoomDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        screeningRoomService.delete(id);
        return ResponseEntity.ok("Xóa phòng chiếu thành công");
    }
}
