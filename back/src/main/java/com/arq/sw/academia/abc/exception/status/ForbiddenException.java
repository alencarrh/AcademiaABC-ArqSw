package com.arq.sw.academia.abc.exception.status;

import java.util.Map;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends HttpStatusException {

    private static final long serialVersionUID = -495404399047981790L;

    public ForbiddenException(final String message) {
        super(message);
    }

    public ForbiddenException(final Throwable cause) {
        super(cause);
    }

    public ForbiddenException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public ForbiddenException(final String key, final String value) {
        super(key, value);
    }

    public ForbiddenException(final Map<String, String> additionalInformation) {
        super(additionalInformation);
    }

    public ForbiddenException(final Throwable cause, final String key, final String value) {
        super(cause, key, value);
    }

    public ForbiddenException(final Throwable cause, final Map<String, String> additionalInformation) {
        super(cause, additionalInformation);
    }

    @Override
    public int getStatusCode() {
        return 403;
    }

}
