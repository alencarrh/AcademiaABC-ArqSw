package com.dev3.academia.abc.exception.status;

import java.util.Map;

public class AttemptLoginException extends HttpStatusException {

    private static final long serialVersionUID = 5940827100601560564L;

    public AttemptLoginException() {
    }

    public AttemptLoginException(final String message) {
        super(message);
    }

    public AttemptLoginException(final String key, final String value) {
        super(key, value);
    }

    public AttemptLoginException(final Map<String, String> additionalInformation) {
        super(additionalInformation);
    }

    @Override
    public int getStatusCode() {
        return 401;
    }
}
