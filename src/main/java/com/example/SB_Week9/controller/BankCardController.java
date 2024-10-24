package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.BankCardDto;
import com.example.SB_Week9.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankcards")
public class BankCardController {
    @Autowired
    private BankCardService bankCardService;

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(bankCardService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(bankCardService.read(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BankCardDto bankCardDto) throws Exception{
        return ResponseEntity.ok().body(bankCardService.create(bankCardDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody BankCardDto bankCardDto) throws Exception{
        return ResponseEntity.ok().body(bankCardService.update(id, bankCardDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        bankCardService.delete(id);
        return ResponseEntity.ok("Xóa thẻ ngân hàng thành công");
    }

}
