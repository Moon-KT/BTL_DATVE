package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.GenreDto;
import com.example.SB_Week9.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(genreService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(genreService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GenreDto genreDto) throws Exception{
        return ResponseEntity.ok().body(genreService.create(genreDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody GenreDto genreDto) throws Exception{
        return ResponseEntity.ok().body(genreService.update(id, genreDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        genreService.delete(id);
        return ResponseEntity.ok("Xóa thể loại thành công");
    }
}
