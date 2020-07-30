package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class InvalidURLException extends IOException {

    public InvalidURLException(String url, Throwable cause) {
        super(String.format(ExceptionsConstants.INVALID_URL_PARAM, url), cause);
    }
}
