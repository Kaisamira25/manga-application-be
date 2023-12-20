package com.alpha.mangaapplication.controller;

import com.alpha.mangaapplication.dto.request.RegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class RegisterController {
   @Operation(description = "Register user account",summary = "Register",responses = {
           @ApiResponse(description = "Successful",responseCode = "200"),
           @ApiResponse(description = "Fail",responseCode = "400")
   })
   @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
      return ResponseEntity.status(HttpStatus.OK).body("Result");
   }
}
