package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.ComboOfferDto;
import com.example.SB_Week9.service.ComboOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/combo-offers")
public class ComboOfferController {
    @Autowired
    private ComboOfferService comboOfferService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(comboOfferService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(comboOfferService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody  ComboOfferDto comboOfferDto) throws Exception{
        return ResponseEntity.ok().body(comboOfferService.update(id, comboOfferDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        comboOfferService.delete(id);
        return ResponseEntity.ok("Xóa combo offer thành công");
    }
}
