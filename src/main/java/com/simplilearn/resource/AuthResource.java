package com.simplilearn.resource;

import com.simplilearn.Dto.JwtDto;
import com.simplilearn.Dto.SignInDto;
import com.simplilearn.Dto.SignUpDto;
import com.simplilearn.config.TokenProvider;
import com.simplilearn.model.User;
import com.simplilearn.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")

public class AuthResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data, HttpSession session) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());

        session.setAttribute("token", accessToken);

        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}