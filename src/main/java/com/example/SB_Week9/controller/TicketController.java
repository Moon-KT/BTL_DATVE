package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.TicketDto;
import com.example.SB_Week9.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TicketDto ticketDto) throws Exception{
        return ResponseEntity.ok().body(ticketService.create(ticketDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> reads(){
        return ResponseEntity.ok().body(ticketService.reads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(ticketService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody TicketDto ticketDto) throws Exception{
        return ResponseEntity.ok().body(ticketService.update(id, ticketDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        ticketService.delete(id);
        return ResponseEntity.ok("Xóa vé thành công");
    }
}
