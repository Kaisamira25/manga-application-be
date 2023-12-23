package com.alpha.mangaapplication.dto.response;

import jakarta.mail.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {
    private int status;
    private String message;
    private Object data;

    public MessageResponse(int status,String message){
        this.status = status;
        this.message = message;
        this.data = "";
    }
}
