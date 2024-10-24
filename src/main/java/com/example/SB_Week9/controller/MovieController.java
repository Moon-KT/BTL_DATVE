package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.MovieDto;
import com.example.SB_Week9.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(movieService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(movieService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MovieDto movieDto) throws Exception{
        return ResponseEntity.ok().body(movieService.create(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody MovieDto movieDto) throws Exception{
        return ResponseEntity.ok().body(movieService.update(id, movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        movieService.delete(id);
        return ResponseEntity.ok("Xóa phim thành công");
    }

}
