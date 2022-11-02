package com.example.demo.responses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private String username;
    private String message;
    private String status;
}
