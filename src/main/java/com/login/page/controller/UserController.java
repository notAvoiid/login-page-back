package com.login.page.controller;

import com.login.page.model.dto.users.UpdateDTO;
import com.login.page.model.dto.users.UserDTO;
import com.login.page.service.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(HttpServletRequest request) {
        var registrationDTOList = userService.getAllUsers();
        return ResponseEntity.ok(registrationDTOList);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username, HttpServletRequest request) {
        UserDTO user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<UpdateDTO> updateUser(@RequestBody UpdateDTO data, HttpServletRequest request) {
        userService.updateUser(data);
        return ResponseEntity.ok(new UpdateDTO(data.name(), data.username(), data.password()));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username, HttpServletRequest request) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
