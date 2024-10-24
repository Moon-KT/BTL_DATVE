package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.ShowtimeDto;
import com.example.SB_Week9.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ShowtimeDto showtimeDto) throws Exception{
        return ResponseEntity.ok().body(showtimeService.create(showtimeDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(showtimeService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable long id) throws Exception{
        return ResponseEntity.ok().body(showtimeService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id,
                                    @RequestBody ShowtimeDto showtimeDto) throws Exception{
        return ResponseEntity.ok().body(showtimeService.update(id, showtimeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
        showtimeService.delete(id);
        return ResponseEntity.ok("Xóa suất chiếu thành công");
    }
}
