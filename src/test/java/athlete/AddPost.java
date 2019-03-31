package athlete;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class AddPost extends SelenideBaseTest {

    @Test(description = "Assert post and comments")
    public void testAssertAddPostAndComment() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doAthleteLogin()
                .doPost("TestPost ", " James Smith ")
                .doAssertPost("TestPost ")
                .doComment("TestComment ")
                .doAssertComment("TestComment ")
                .doDeletePost()
                .doFollowers("James Smith")
                .doFollowing("James Smith");
    }
}

