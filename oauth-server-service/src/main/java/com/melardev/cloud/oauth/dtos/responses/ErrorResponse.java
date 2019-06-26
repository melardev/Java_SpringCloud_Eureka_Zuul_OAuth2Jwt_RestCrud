package com.melardev.cloud.oauth.dtos.responses;

public class ErrorResponse extends AppResponse {

    public ErrorResponse(String errorMessage) {
        super(false);
        addFullMessage(errorMessage);
    }

}
