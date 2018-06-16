package com.arq.sw.academia.abc.exception.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PreconditionFailedException extends HttpStatusException {


    public PreconditionFailedException() {
    }

    public PreconditionFailedException(final String message) {
        super(message);
    }

    public PreconditionFailedException(final Throwable cause) {
        super(cause);
    }

    public PreconditionFailedException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public PreconditionFailedException(final String key, final String value) {
        super(key, value);
    }

    public PreconditionFailedException(final Map<String, String> additionalInformation) {
        super(additionalInformation);
    }

    public PreconditionFailedException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    public PreconditionFailedException(final Throwable cause, final Map<String, String> additionalInformation) {
        super(cause, additionalInformation);
    }

    @Override
    public int getStatusCode() {
        return 412;
    }
}
