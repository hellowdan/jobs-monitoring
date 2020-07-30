package org.jboss.qa.monitoring.health.exceptions;

public abstract class ExceptionsConstants {

    public static final String FAILED_GENERATE_REPORT = "Failed generating the performance report";
    public static final String FILE_NOT_FOUND_PARAM = "File not found: %s";
    public static final String FILE_CANNOT_BE_READ = "File cannot be read";
    public static final String FILE_CANNOT_BE_READ_PARAM = "File cannot be read: %s";
    public static final String FILE_CANNOT_BE_PARSED = "File cannot be parsed";
    public static final String FILE_CANNOT_BE_PARSED_PARAM = "File cannot be parsed: %s";
    public static final String INVALID_URL_PARAM = "Invalid URL: %s";
    public static final String CONTENT_FROM_URL_CANNOT_BE_READ_PARAM = "Content from %s cannot be read";
    public static final String FAILED_CREATE_FOLDER_GOOGLE_DRIVE = "Failed creating the folder %s on Google Drive";
    public static final String FAILED_MOVE_FILE_GOOGLE_DRIVE = "Failed moving a file to a new folder on Google Drive";
    public static final String FAILED_COPY_FILE_GOOGLE_DRIVE = "Failed copying a file on Google Drive";
    public static final String FAILED_DOWNLOAD_FILE_GOOGLE_DRIVE_PARAM = "Failed downloading a file from Google Drive. Google ID: %s";
    public static final String FAILED_SHARE_FILE_GOOGLE_DRIVE_PARAM = "Failed sharing a file from Google Drive. Google ID: %s";
    public static final String FAILED_SAVE_TO_DISK = "Failed to save file to disk: %s";
    public static final String FAILED_GET_GOOGLE_CREDENCIALS = "Failed to get Google Drive credentials";
    public static final String FAILED_UPDATE_SPREADSHEET_VALUES = "Failed updating numeric values on Google Drive's spreadSheet";
    public static final String FAILED_UPDATE_SPREADSHEET_TEXT = "Failed updating text content on Google Drive's spreadSheet";
    public static final String INVALID_FILE_EXTENSION_PARAM = "Invalid file extension: %s";
    public static final String FAILED_GENERATE_JSON_FROM_CSV_PARAM = "Failed on generating JSON from CSV file: %s";
    public static final String FAILED_MAP_JSON_FROM_CSV_PARAM = "Failed on mapping JSON from CSV file: %s";
    public static final String FAILED_PREPARING_GOOGLE_DRIVE_FILES = "Failed preparing files to download from Google Drive";
    public static final String FAILED_SAVING_TO_DATABASE = "Failed saving %s to database";

    private ExceptionsConstants() {
    }
}
