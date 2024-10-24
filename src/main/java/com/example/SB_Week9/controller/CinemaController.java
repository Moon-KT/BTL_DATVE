package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(cinemaService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(cinemaService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CinemaDto cinemaDto) throws Exception{
        return ResponseEntity.ok().body(cinemaService.create(cinemaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody CinemaDto cinemaDto) throws Exception{
        return ResponseEntity.ok().body(cinemaService.update(id, cinemaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        cinemaService.delete(id);
        return ResponseEntity.ok("Xóa rạp thành công");
    }

}
