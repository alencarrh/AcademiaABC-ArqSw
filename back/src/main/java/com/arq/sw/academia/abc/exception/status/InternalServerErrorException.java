package com.arq.sw.academia.abc.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends HttpStatusException {

    private static final long serialVersionUID = 4627560309261727547L;

    public InternalServerErrorException() {
    }

    public InternalServerErrorException(final String message) {
        super(message);
    }

    public InternalServerErrorException(final Throwable cause) {
        super(cause);
    }

    public InternalServerErrorException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public InternalServerErrorException(final String key, final String value) {
        super(key, value);
    }

    public InternalServerErrorException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    @Override
    public int getStatusCode() {
        return 500;
    }
}
