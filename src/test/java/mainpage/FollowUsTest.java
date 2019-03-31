package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class FollowUsTest extends SelenideBaseTest {
    @Test(description = "Assert social icons int the section follow us on the main page")
    public void testAssertFollowUs() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        pages.doAssertFollowUsSocialIcons().shouldHaveSize(4);
    }
}
