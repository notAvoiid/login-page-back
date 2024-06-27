package com.login.page.controller;

import com.login.page.model.dto.users.AuthenticationDTO;
import com.login.page.model.dto.users.LoginResponseDTO;
import com.login.page.model.dto.users.RegisterDTO;
import com.login.page.service.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody RegisterDTO data, HttpServletRequest request) {
        return ResponseEntity.ok(userService.register(data));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO authenticationDTO, HttpServletRequest request) {
        return ResponseEntity.ok(userService.login(authenticationDTO));
    }

}
