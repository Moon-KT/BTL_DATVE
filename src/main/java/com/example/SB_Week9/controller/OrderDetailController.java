//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.OrderDetailDto;
//import com.example.SB_Week9.service.OrderDetailService;
//import com.example.SB_Week9.service.OrderService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/orderdetails")
//public class OrderDetailController {
//    private OrderDetailService orderDetailService;
//    private OrderService orderService;
//
//    @PostMapping("/order")
//    public ResponseEntity<?> createOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
//        return ResponseEntity.ok().body(orderDetailService.create(orderDetailDto));
//    }
//
////    @PostMapping("/orderProduct")
////    public ResponseEntity<?> orderProduct(@RequestParam long userId, @RequestParam long productId) throws Exception {
////        OrderDto orderDto= new OrderDto(userId);
////        orderService.create(orderDto);
////        List<Order> order = orderService.findByUser(orderDto.getUserOrderId());
////        OrderDetailDto orderDetailDto= new OrderDetailDto(order.get(order.size()-1).getId(),productId);
////        return ResponseEntity.ok().body(orderDetailService.create(orderDetailDto));
////    }
//
//    @GetMapping
//    public ResponseEntity<?> reads(){
//        return ResponseEntity.ok().body(orderDetailService.read());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> read(@PathVariable long id) throws Exception{
//        return ResponseEntity.ok().body(orderDetailService.read(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable long id,
//                                    @RequestBody OrderDetailDto orderDetailDto)throws Exception{
//        return ResponseEntity.ok().body(orderDetailService.update(id, orderDetailDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
//        orderDetailService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//}
