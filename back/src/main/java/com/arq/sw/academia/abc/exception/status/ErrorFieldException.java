package com.arq.sw.academia.abc.exception.status;

public class ErrorFieldException extends Throwable {

    private static final long serialVersionUID = -6590706769724027956L;

    public ErrorFieldException(String field) {
        super(field);
    }

}
