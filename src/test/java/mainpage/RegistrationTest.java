package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class RegistrationTest extends SelenideBaseTest {
    @Test(description = "Assert section registration")
    public void testAssertRegistration() {
        Pages pages = new Pages();
        pages
                .openPage(loadProperty("EnHome"))
                .doCheckRegistration();
    }

}
