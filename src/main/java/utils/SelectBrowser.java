package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

/**
 * An Class Select Browser.
 */

@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter", "PMD.LawOfDemeter"})
public final class SelectBrowser {

    /**
     * Private constructor.
     */
    private SelectBrowser() {
    }

    /**
     * Method select browser and setting the settings.
     *
     * @param browser browser.
     */
    public static void selectBrowser(final String browser) {

        switch (browser) {
            case "Chrome":
                Configuration.browser = "Chrome";
                ChromeDriverManager.getInstance().setup();
                break;
            case "Firefox":
                Configuration.browser = "Firefox";
                FirefoxDriverManager.getInstance().setup();
                break;

            default:
                throw new IllegalStateException("Browser " + browser + " not supported in tests");
        }
    }
}

