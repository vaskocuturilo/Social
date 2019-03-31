package coach;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class AddPageInformation extends SelenideBaseTest {

    @Test(description = "Assert page information")
    public void testAssertPageInformation() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doCoachLogin()
                .doAssertCoachMenu()
                .doAssertCoachProfile()
                .doAssertCoachPageInformation("John Smith");
    }
}
