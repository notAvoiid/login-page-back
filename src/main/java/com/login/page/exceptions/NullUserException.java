package com.login.page.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullUserException extends RuntimeException  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public NullUserException() {
        super("User doesn't exist in database!");
    }
    public NullUserException(String message) {
        super(message);
    }

}
