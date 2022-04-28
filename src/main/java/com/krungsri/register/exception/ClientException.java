package com.krungsri.register.exception;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class ClientException extends ApiException {
    public ClientException(String code, String message, String description) {
        super.code = code;
        this.message = message;
        this.description = description;
    }
    public ClientException(String code, String message) {
        super.code = code;
        this.message = message;
    }
    public ClientException(String message) {
        this.message = message;
    }
}
