package signportal.athlete;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

public class SignInAuthenticationPassTest extends SelenideBaseTest {

    @Test(description = "Login athlete user")
    public void getSignInAuthenticationPassTest() {
        Pages pages = new Pages();
        pages.openPage("");
        new SignUpPage()
                .doAthleteLogin()
                .doAssertFirstNameUser("John")
                .doLogout();
    }
}

