package com.arq.sw.academia.abc.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpStatusException {

    private static final long serialVersionUID = 7826032802947308055L;

    public BadRequestException() {
    }

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final Throwable cause) {
        super(cause);
    }

    public BadRequestException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public BadRequestException(final String key, final String value) {
        super(key, value);
    }

    public BadRequestException(final Map<String, String> additionalInformation) {
        super(additionalInformation);
    }

    public BadRequestException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    public BadRequestException(final Throwable cause, final Map<String, String> additionalInformation) {
        super(cause, additionalInformation);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
