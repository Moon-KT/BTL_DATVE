//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.OrderDto;
//import com.example.SB_Week9.entity.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping
//    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto){
//        return ResponseEntity.ok().body(orderService.create(orderDto));
//    }
//
//    @GetMapping
//    public ResponseEntity<?> reads(){
//        return ResponseEntity.ok().body(orderService.read());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> read(@PathVariable long id) throws Exception{
//        return ResponseEntity.ok().body(orderService.read(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable long id,
//                                    @RequestBody OrderDto orderDto)throws Exception{
//        return ResponseEntity.ok().body(orderService.update(id, orderDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
//        orderService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<?> findOrderbyUser(@RequestBody User user){
//        return ResponseEntity.ok().body(orderService.findOrdersByUser(user));
//    }
//}
