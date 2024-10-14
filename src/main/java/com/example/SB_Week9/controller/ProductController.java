//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.ProductDto;
//import com.example.SB_Week9.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping
//    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
//        return ResponseEntity.ok().body(productService.create(productDto));
//    }
//
//    @GetMapping
//    public ResponseEntity<?> reads(){
//        return ResponseEntity.ok().body(productService.read());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> read(@PathVariable long id) throws Exception{
//        return ResponseEntity.ok().body(productService.read(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable long id,
//                                    @RequestBody ProductDto productDto)throws Exception{
//        return ResponseEntity.ok().body(productService.update(id, productDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
//        productService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//}
