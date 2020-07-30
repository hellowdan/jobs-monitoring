package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class GoogleDriveMoveFileException extends IOException {

    public GoogleDriveMoveFileException(Throwable cause) {
        super(ExceptionsConstants.FAILED_MOVE_FILE_GOOGLE_DRIVE, cause);
    }
}
