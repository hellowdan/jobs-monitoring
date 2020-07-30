package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class FileCannotBeFoundException extends IOException {

    public FileCannotBeFoundException(String filePath, Throwable cause) {
        super(String.format(ExceptionsConstants.FILE_NOT_FOUND_PARAM, filePath), cause);
    }
}
