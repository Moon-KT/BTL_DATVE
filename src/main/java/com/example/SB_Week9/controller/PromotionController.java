package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.PromotionDto;
import com.example.SB_Week9.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(promotionService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(promotionService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PromotionDto promotionDto) throws Exception{
        return ResponseEntity.ok().body(promotionService.create(promotionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody PromotionDto promotionDto) throws Exception{
        return ResponseEntity.ok().body(promotionService.update(id, promotionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        promotionService.delete(id);
        return ResponseEntity.ok("Xóa khuyến mãi thành công");
    }
}
