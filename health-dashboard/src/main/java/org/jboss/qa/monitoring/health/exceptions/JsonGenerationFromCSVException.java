package org.jboss.qa.monitoring.health.exceptions;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;

public class JsonGenerationFromCSVException extends JsonGenerationException {

    public JsonGenerationFromCSVException(String filePath, Throwable cause, JsonGenerator g) {
        super(String.format(ExceptionsConstants.FAILED_GENERATE_JSON_FROM_CSV_PARAM, filePath), cause, g);
    }
}
