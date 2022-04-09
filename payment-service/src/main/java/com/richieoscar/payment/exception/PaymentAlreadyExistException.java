package com.richieoscar.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PaymentAlreadyExistException extends RuntimeException {
    public PaymentAlreadyExistException(String message) {
        super(message);
    }
}
