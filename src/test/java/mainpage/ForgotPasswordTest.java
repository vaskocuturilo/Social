package mainpage;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;

import static utils.PropertiesReader.loadProperty;

public class ForgotPasswordTest extends SelenideBaseTest {

    @Test(description = "Verify information message for functional forgot password")
    public void testForgotPassword() {
        Pages pages = new Pages();
        pages
                .openPage(loadProperty("EnHome"))
                .assertForgotPasswordForm()
                .assertUnconfirmed("athlete270@qa.team")
                .assertNonExistent("athlete271@qa.team")
                .assertEmptyEmail("");
    }
}
