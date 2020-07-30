package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class FileCannotBeSavedException extends IOException {

    public FileCannotBeSavedException(String filePath, Throwable cause) {
        super(String.format(ExceptionsConstants.FAILED_SAVE_TO_DISK, filePath), cause);
    }
}
