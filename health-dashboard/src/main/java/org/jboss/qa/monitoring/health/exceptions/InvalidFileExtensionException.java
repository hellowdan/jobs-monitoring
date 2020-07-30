package org.jboss.qa.monitoring.health.exceptions;

import org.jboss.qa.monitoring.health.definitions.SourceFileExtension;

public class InvalidFileExtensionException extends IllegalArgumentException {

    public InvalidFileExtensionException(SourceFileExtension fileExtension) {
        super(String.format(ExceptionsConstants.INVALID_FILE_EXTENSION_PARAM, fileExtension.getExtension()));
    }
}
