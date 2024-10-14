//package com.example.SB_Week9.controller;
//
//import com.example.SB_Week9.dto.UserDto;
//import com.example.SB_Week9.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
//        return ResponseEntity.ok().body(userService.create(userDto));
//    }
//
//    @GetMapping
//    public ResponseEntity<?> reads(){
//        return ResponseEntity.ok().body(userService.getAllUsers());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> read(@PathVariable long id) throws Exception{
//        return ResponseEntity.ok().body(userService.getUserById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable long id,
//                                    @RequestBody UserDto userDto)throws Exception{
//        return ResponseEntity.ok().body(userService.update(id, userDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable long id) throws Exception{
//        userService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//}
