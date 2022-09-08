package com.booking.authservice.controller;

import com.booking.authservice.security.JwtUtil;
import com.booking.authservice.dto.AuthRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequestDTO dto) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUserName(),dto.getPassword()));
        }catch (Exception ex){
            throw new Exception("invalid username or password...");
        }
        return jwtUtil.generateToken(dto.getUserName());
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world...";
    }
}