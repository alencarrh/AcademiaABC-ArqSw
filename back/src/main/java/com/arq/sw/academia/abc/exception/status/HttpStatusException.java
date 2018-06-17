package com.arq.sw.academia.abc.exception.status;

import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Getter
public abstract class HttpStatusException extends RuntimeException {

    private static final long serialVersionUID = -2134691716833080281L;

    private Map<String, String> additionalInformation;

    public HttpStatusException() {
    }

    public HttpStatusException(final String message) {
        super(message);
    }

    public HttpStatusException(final Throwable cause) {
        super(cause);
    }

    public HttpStatusException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public HttpStatusException(final String key, final String value) {
        addAdditionalInformation(key, value);
    }

    public HttpStatusException(final Throwable cause, final String key, final String value) {
        super(cause);
        addAdditionalInformation(key, value);
    }

    public HttpStatusException(final Throwable cause, final Map<String, String> additionalInformation) {
        super(cause);
        addAdditionalInformation(additionalInformation);
    }

    public HttpStatusException(final Map<String, String> additionalInformation) {
        addAdditionalInformation(additionalInformation);
    }

    public void addAdditionalInformation(final String key, final String value) {

        if(isNull(additionalInformation)) {
            additionalInformation = new TreeMap<>();
        }

        additionalInformation.put(key, value);
    }

    public void addAdditionalInformation(final Map<String, String> additionalInformation) {

        ofNullable(additionalInformation)
                .ifPresent(map -> map.forEach((key, value) -> addAdditionalInformation(key, value)));
    }

    public abstract int getStatusCode();

}
