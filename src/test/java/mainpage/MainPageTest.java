package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class MainPageTest extends SelenideBaseTest {
    @Test(description = " Assert main, about us and faq pages")
    public void testOpenMainPage() {
        Pages pages = new Pages();
        pages
                .openPage(loadProperty("EnHome"))
                .assertMainPage()
                .assertAboutUs()
                .assertFaq();
    }

}
