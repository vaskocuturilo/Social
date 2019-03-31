package coach;

import driver.SelenideBaseTest;
import org.testng.annotations.Test;
import pages.Pages;
import pages.SignUpPage;

import static utils.PropertiesReader.loadProperty;

public class AddPost extends SelenideBaseTest {

    @Test(description = "Assert post and comment")
    public void testAssertPostAndComment() {
        Pages pages = new Pages();
        pages.openPage(loadProperty("EnHome"));
        new SignUpPage()
                .doCoachLogin()
                .doPost("TestPost "," John Smith ")
                .doAssertPost("TestPost ")
                .doComment("TestComment ")
                .doAssertComment("TestComment ")
                .doDeletePost()
                .doFollowers("John Smith")
                .doFollowing("John Smith");
    }
}

