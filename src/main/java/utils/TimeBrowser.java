package utils;

import com.codeborne.selenide.Configuration;

/**
 * An Class Time Browser.
 *
 * @author Anton Smirnov
 * @version 1.0
 */
public final class TimeBrowser {

    /**
     * Default private constructor time browser.
     */
    private TimeBrowser() {
    }

    /**
     * Method set time browser.
     *
     * @param timeBrowser Time for Browser.
     */
    public static void setTimeBrowser(final long timeBrowser) {

        Configuration.timeout = timeBrowser;
    }
}
