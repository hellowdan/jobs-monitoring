package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class GoogleDriveShareFileException extends IOException {

    public GoogleDriveShareFileException(String fileID, Throwable cause) {
        super(String.format(ExceptionsConstants.FAILED_SHARE_FILE_GOOGLE_DRIVE_PARAM, fileID), cause);
    }
}
