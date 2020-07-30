package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class FileCannotBeReadException extends IOException {

    public FileCannotBeReadException(Throwable cause) {
        super(ExceptionsConstants.FILE_CANNOT_BE_READ, cause);
    }

    public FileCannotBeReadException(String fileName, Throwable cause) {
        super(String.format(ExceptionsConstants.FILE_CANNOT_BE_READ_PARAM, fileName), cause);
    }
}
