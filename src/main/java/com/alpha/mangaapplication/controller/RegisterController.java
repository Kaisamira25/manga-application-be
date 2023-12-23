package com.alpha.mangaapplication.controller;

import com.alpha.mangaapplication.dto.request.RegisterDTO;
import com.alpha.mangaapplication.dto.response.MessageResponse;
import com.alpha.mangaapplication.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;
   @Operation(description = "Register user account",summary = "Register",responses = {
           @ApiResponse(description = "Successful",responseCode = "200"),
           @ApiResponse(description = "Fail",responseCode = "400")
   })
   @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
      int status = registerService.register(registerDTO);
      if (status == 0){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                  .body(new MessageResponse(0,"Email or password wrong format"));
      }else if (status == 1){
          return ResponseEntity.status(HttpStatus.OK)
                  .body(new MessageResponse(1,"Success create account for user"));
      }
      return ResponseEntity.status(HttpStatus.FOUND)
              .body(new MessageResponse(2,"Account already exist"));
   }
}
