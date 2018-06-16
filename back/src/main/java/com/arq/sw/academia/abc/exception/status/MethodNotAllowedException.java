package com.arq.sw.academia.abc.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends HttpStatusException {

    public MethodNotAllowedException() {
    }

    public MethodNotAllowedException(final String message) {
        super(message);
    }

    public MethodNotAllowedException(final Throwable cause) {
        super(cause);
    }

    public MethodNotAllowedException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public MethodNotAllowedException(final String key, final String value) {
        super(key, value);
    }

    public MethodNotAllowedException(final Map<String, String> additionalInformation) {
        super(additionalInformation);
    }

    public MethodNotAllowedException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    public MethodNotAllowedException(final Throwable cause, final Map<String, String> additionalInformation) {
        super(cause, additionalInformation);
    }

    @Override
    public int getStatusCode() {
        return 405;
    }
}
