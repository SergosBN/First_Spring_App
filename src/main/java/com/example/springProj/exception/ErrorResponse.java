package com.example.springProj.exception;

public class ErrorResponse {             // 3. EXCEPTION RESPONSE

    private String message;
    private int status;

    public ErrorResponse(String message, int status){
        this.message = message;
        this.status = status;
    }

    public String getMessage(){return message;}

    public int getStatus(){return status;}
}
