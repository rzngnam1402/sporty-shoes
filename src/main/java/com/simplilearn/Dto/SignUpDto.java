package com.simplilearn.Dto;

import com.simplilearn.enums.UserRole;

// dtos/SignUpDto.java
public record SignUpDto(
        String login,
        String password,
        UserRole role) {
}