package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class InvalidContentFromURLException extends IOException {

    public InvalidContentFromURLException(String url, Throwable cause) {
        super(String.format(ExceptionsConstants.CONTENT_FROM_URL_CANNOT_BE_READ_PARAM, url), cause);
    }
}
