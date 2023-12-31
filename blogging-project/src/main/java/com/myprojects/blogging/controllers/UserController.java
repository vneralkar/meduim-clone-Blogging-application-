package com.myprojects.blogging.controllers;

import com.myprojects.blogging.payloads.UserDto;
import com.myprojects.blogging.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createuserdto = this.userService.createUser(userDto);

        return new ResponseEntity<>(createuserdto, HttpStatus.CREATED) ;

    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
        UserDto updateduser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateduser);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleuser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
//        return new ResponseEntity(Map.of("message", "deleted"), HttpStatus.ok());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        return ResponseEntity.ok(this.userService.getallusers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserbyId(userId));
    }
}
