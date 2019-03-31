package signportal.coach;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Pages;
import pages.SignUpPage;

public class SignInAuthenticationPassTest extends SelenideBaseTest {

    @Test(description = "Login coach user")
    public void getSignInAuthenticationPassTest() {
        Pages pages = new Pages();
        pages.openPage("");
        new SignUpPage()
                .doCoachLogin()
                .doAssertFirstNameUser("James")
                .doLogout();
    }
}

