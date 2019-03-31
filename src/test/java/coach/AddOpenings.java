package coach;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class AddOpenings extends SelenideBaseTest {

    @Test(description = "Add openings")
    public void testAddOpenings() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doCoachLogin()
                .doAddOpenings()
                .doDeleteOpening();
    }
}
