package org.jboss.qa.monitoring.health.exceptions;

import java.io.IOException;

public class GoogleDriveFolderCreateException extends IOException {

    public GoogleDriveFolderCreateException(String folderName, Throwable cause) {
        super(String.format(ExceptionsConstants.FAILED_CREATE_FOLDER_GOOGLE_DRIVE, folderName), cause);
    }
}
