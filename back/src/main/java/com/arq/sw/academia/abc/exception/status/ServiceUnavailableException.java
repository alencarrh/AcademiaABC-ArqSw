package com.arq.sw.academia.abc.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends HttpStatusException {

    private static final long serialVersionUID = -1280594911580488219L;

    public ServiceUnavailableException() {
    }

    public ServiceUnavailableException(final String message) {
        super(message);
    }

    public ServiceUnavailableException(final Throwable cause) {
        super(cause);
    }

    public ServiceUnavailableException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public ServiceUnavailableException(final String key, final String value) {
        super(key, value);
    }

    public ServiceUnavailableException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    @Override
    public int getStatusCode() {
        return 503;
    }
}
