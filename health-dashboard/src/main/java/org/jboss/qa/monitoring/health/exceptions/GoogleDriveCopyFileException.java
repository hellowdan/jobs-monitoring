package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class GoogleDriveCopyFileException extends IOException {

    public GoogleDriveCopyFileException(Throwable cause) {
        super(ExceptionsConstants.FAILED_COPY_FILE_GOOGLE_DRIVE, cause);
    }
}
