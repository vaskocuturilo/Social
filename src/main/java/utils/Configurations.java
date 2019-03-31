package utils;

import com.codeborne.selenide.Configuration;

/**
 * An Class configurations.
 *
 * @author Anton Smirnov
 * @version 1.0
 */
public final class Configurations {

    /**
     * Default private constructor configurations.
     */
    private Configurations() {
    }


    /**
     * Method set report folder.
     *
     * @param reportFolder set report folder.
     */
    public static void setReportFolder(final String reportFolder) {

        Configuration.reportsFolder = reportFolder;
    }

    /**
     * Method set base url.
     *
     * @param baseUrl base url.
     */
    public static void setBaseUrl(final String baseUrl) {

        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = "1300x768";
    }

}

