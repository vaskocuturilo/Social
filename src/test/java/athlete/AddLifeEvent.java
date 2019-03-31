package athlete;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class AddLifeEvent extends SelenideBaseTest {

    @Test(description = "Add life event")
    public void testAddAthleteLifeEvent() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doAthleteLogin()
                .doAssertFirstNameUser("John")
                .doAddLifeEvent("Auto test","Auto test")
                .doAssertLifeEvent("Auto test")
                .doLogout();
    }
}
