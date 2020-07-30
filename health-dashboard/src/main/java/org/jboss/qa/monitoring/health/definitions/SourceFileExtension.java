package org.jboss.qa.monitoring.health.definitions;

public enum SourceFileExtension {
    CSV("csv"),
    JSON("json");

    private String extension;

    SourceFileExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public static SourceFileExtension getExtension(String extension) {
        if (extension.equals(CSV.toString())) {
            return SourceFileExtension.CSV;
        } else if (extension.equals(JSON.toString())) {
            return SourceFileExtension.JSON;
        } else {
            return null;
        }
    }
}
