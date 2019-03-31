package signportal.authenticationfail;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class SingInAuthenticationFailTest extends SelenideBaseTest {

    @Test(description = "Fail Login")
    public void testSignInAuthenticationFail() {
        new Pages()
                .openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doFailLogin()
                .assertEnteredIsIncorrect("Credentials do not match our records!");

    }
}
