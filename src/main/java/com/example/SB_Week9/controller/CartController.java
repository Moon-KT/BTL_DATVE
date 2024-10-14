//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.CartDto;
//import com.example.SB_Week9.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/carts")
//public class CartController {
//        @Autowired
//        private CartService cartService;
//
//        @PostMapping
//        public ResponseEntity<?> createCart(@RequestBody CartDto cartDto){
//            return ResponseEntity.ok().body(cartService.create(cartDto));
//        }
//
//        @GetMapping
//        public ResponseEntity<?> reads(){
//            return ResponseEntity.ok().body(cartService.read());
//        }
//
//        @GetMapping("/{id}")
//        public ResponseEntity<?> read(@PathVariable long id) throws Exception{
//            return ResponseEntity.ok().body(cartService.read(id));
//        }
//
//        @PutMapping("/{id}")
//        public ResponseEntity<?> update(@PathVariable long id,
//                                        @RequestBody CartDto cartDto)throws Exception{
//            return ResponseEntity.ok().body(cartService.update(id, cartDto));
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
//            cartService.delete(id);
//            return ResponseEntity.ok().build();
//        }
//    }
