package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class GoogleDriveDownloadFileException extends IOException {

    public GoogleDriveDownloadFileException(String fileID, Throwable cause) {
        super(String.format(ExceptionsConstants.FAILED_DOWNLOAD_FILE_GOOGLE_DRIVE_PARAM, fileID), cause);
    }
}
