package driver;

import org.testng.annotations.*;
import utils.AllureScreenShooter;
import utils.Configurations;
import utils.SelectBrowser;
import utils.TimeBrowser;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.PropertiesReader.loadProperty;


/**
 * An Class selenide base test.
 */
@Listeners({AllureScreenShooter.class})
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class SelenideBaseTest {

    /**
     * Default constructor selenide base test.
     */
    public SelenideBaseTest() {
        super();
        //empty constructor
        return;
    }

    /**
     * Method setup(), start driver, browser, set settings.
     */
    @BeforeClass
    public void setup() {
        TimeBrowser.setTimeBrowser(Long.parseLong(loadProperty("TIMEOUT")));
        Configurations.setReportFolder(loadProperty("REPORT_FOLDER"));
        SelectBrowser.selectBrowser("Firefox");
        Configurations.setBaseUrl(loadProperty("MainPage"));
    }

    /**
     * Method after(), close driver, clear cache.
     */
    @AfterClass
    public void after() {
        closeWebDriver();
        clearBrowserCache();
    }
}



