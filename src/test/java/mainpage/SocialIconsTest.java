package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class SocialIconsTest extends SelenideBaseTest {
    @Test(description = "Assert social icons on the main page")
    public void testAssertSocialIcons() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        pages.doCheckSocialIcons().shouldHaveSize(4);
    }
}
