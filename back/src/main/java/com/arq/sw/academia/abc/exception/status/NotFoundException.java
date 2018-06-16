package com.arq.sw.academia.abc.exception.status;

public class NotFoundException extends HttpStatusException {

    private static final long serialVersionUID = -681223971222378859L;

    public NotFoundException() {
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String key, final String value) {
        super(key, value);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
