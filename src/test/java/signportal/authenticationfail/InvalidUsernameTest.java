package signportal.authenticationfail;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class InvalidUsernameTest extends SelenideBaseTest {

    @Test(description = "Login invalid user name")
    public void testInvalidUsernameTest() {
        new Pages()
                .openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doInvalidUserName()
                .assertEnteredIsIncorrect(" Invalid password or username ");

    }
}
