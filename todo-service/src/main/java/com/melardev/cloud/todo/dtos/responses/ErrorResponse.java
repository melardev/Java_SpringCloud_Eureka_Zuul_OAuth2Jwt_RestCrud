package com.melardev.cloud.todo.dtos.responses;

public class ErrorResponse extends AppResponse {

    public ErrorResponse(String errorMessage) {
        super(false);
        addFullMessage(errorMessage);
    }

}
