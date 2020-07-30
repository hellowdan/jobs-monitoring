package org.jboss.qa.monitoring.health.definitions;

public enum SourceFileLocation {
    LOCAL("LOCAL"),
    WEB("WEB"),
    DRIVE("DRIVE"),
    CLASSPATH("CLASSPATH");

    private String location;

    SourceFileLocation(String location) {
        this.location = location;
    }

    public static SourceFileLocation getLocation(String location) {
        if (location.equals(LOCAL.toString())) {
            return SourceFileLocation.LOCAL;
        } else if (location.equals(WEB.toString())) {
            return SourceFileLocation.WEB;
        } else if (location.equals(DRIVE.toString())) {
            return SourceFileLocation.DRIVE;
        } else if (location.equals(CLASSPATH.toString())) {
            return SourceFileLocation.CLASSPATH;
        } else {
            return null;
        }
    }
}
