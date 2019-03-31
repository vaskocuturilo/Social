package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class InstagramTest extends SelenideBaseTest {
    @Test(description = "Assert section Instagram on the main page")
    public void testAssertInstagramImages() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        pages.doInstagramImage().shouldHaveSize(4);
    }
}
