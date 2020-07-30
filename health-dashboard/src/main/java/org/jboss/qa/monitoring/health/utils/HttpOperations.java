package org.jboss.qa.monitoring.health.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.jboss.qa.monitoring.health.exceptions.InvalidContentFromURLException;
import org.jboss.qa.monitoring.health.exceptions.InvalidURLException;

public class HttpOperations {

    private HttpOperations() {
    }

    public static Object getFileObjectFromWeb(String url) throws IOException {
        Object input = null;

        try {
            URL urlFile = new URL(url);
            if ("https".equals(urlFile.getProtocol())) {
                input = getFileObjectFromHTTPS(urlFile);
            } else if ("http".equals(urlFile.getProtocol())) {
                input = getFileObjectFromHTTP(urlFile);
            }
        } catch (MalformedURLException e) {
            throw new InvalidURLException(url, e);
        }

        return input;
    }

    public static Reader getFileReaderFromWeb(String url) throws IOException {
        Reader input = null;

        try {
            URL urlFile = new URL(url);
            if ("https".equals(urlFile.getProtocol())) {
                input = getFileReaderFromHTTPS(urlFile);
            } else if ("http".equals(urlFile.getProtocol())) {
                input = getFileReaderFromHTTP(urlFile);
            }

        } catch (MalformedURLException e) {
            throw new InvalidURLException(url, e);
        }
        return input;
    }

    private static Reader getFileReaderFromHTTPS(URL url) throws IOException {
        Reader input;
        System.out.println("getFileReaderFromHTTPS-Reader - "+url.toString());

        try {
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            input = new BufferedReader(in);
        } catch (IOException e) {
            throw new InvalidContentFromURLException(url.getPath(), e);
        }

        return input;
    }

    private static Reader getFileReaderFromHTTP(URL url) throws IOException {
        Reader input;
        System.out.println("getFileReaderFromHTTP-Reader - "+url.toString());

        try {
            URLConnection urlConn = url.openConnection();
            InputStreamReader in = new InputStreamReader((urlConn).getInputStream());
            input = new BufferedReader(in);
        } catch (IOException e) {
            throw new InvalidContentFromURLException(url.getPath(), e);
        }

        return input;
    }

    private static Object getFileObjectFromHTTPS(URL url) throws IOException {
        Object input;
        System.out.println("getFileReaderFromHTTPS");

        try {
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            input = new BufferedReader(in);
        } catch (IOException e) {
            throw new InvalidContentFromURLException(url.getPath(), e);
        }

        return input;
    }

    private static Object getFileObjectFromHTTP(URL url) throws IOException {
        Object input;
        System.out.println("getFileReaderFromHTTP-Object");

        try {
            URLConnection urlConn = url.openConnection();
            InputStreamReader in = new InputStreamReader((urlConn).getInputStream());
            input = new BufferedReader(in);
        } catch (IOException e) {
            throw new InvalidContentFromURLException(url.getPath(), e);
        }

        return input;
    }
}
