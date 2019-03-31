package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static utils.PropertiesReader.loadProperty;

/**
 * An Class Login page.
 */
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class LoginPage {

    /**
     * Selenide Elements.
     */
    private static final SelenideElement
            PASSWORD_FIELD = $("input[id='login-Password']"),
            EMAIL_FIELD = $("input[id='login-Email']"),
            LOGIN_BUTTON = $("button[id='public-navigation-login-button']"),
            PERSONAL_AREA = $("#navbar-mobile li.dropdown.dropdown-user > a"),
            LOGOUT_LINK = $("#navbar-mobile li.dropdown.dropdown-user.open li:nth-child(5) a");

    /**
     * Constant DELAY_FOR_WAIT.
     */
    private static final int DELAY_FOR_WAIT = 5000;

    /**
     * Default constructor for class Login Page.
     */
    public LoginPage() {
        super();
        //empty constructor.
        return;
    }

    /**
     * Method enter user email.
     *
     * @param login user login.
     * @return return this.
     */
    public LoginPage enterUserEmail(final String login) {
        EMAIL_FIELD.clear();
        executeJavaScript("document.getElementById('login-Email').value = '" + login + "' ");

        return this;
    }

    /**
     * Method enter user password.
     *
     * @param password user password.
     * @return return this.
     */
    public LoginPage enterPassword(final String password) {
        PASSWORD_FIELD.clear();
        executeJavaScript("document.getElementById('login-Password').value = '" + password + "' ");

        return this;
    }

    /**
     * Method click on login button.
     *
     * @return this.
     */
    public LoginPage clickOnLoginButton() {
        LOGIN_BUTTON.waitUntil(enabled, DELAY_FOR_WAIT).click();

        return this;
    }

    /**
     * Method do athlete login.
     *
     * @return return this.
     */
    public SignUpPage doAthleteLogin() {
        enterUserEmail(loadProperty("athleteUser"));
        enterPassword(loadProperty("Password"));
        clickOnLoginButton();

        return new SignUpPage();
    }

    /**
     * Method do coach login.
     *
     * @return return this.
     */
    public SignUpPage doCoachLogin() {
        enterUserEmail(loadProperty("coachUser"));
        enterPassword(loadProperty("Password"));
        clickOnLoginButton();

        return new SignUpPage();
    }

    /**
     * Method do invalid login.
     *
     * @return return this.
     */
    public SignUpPage doInvalidUserName() {
        enterUserEmail(loadProperty("coachUser"));
        enterPassword("");
        clickOnLoginButton();

        return new SignUpPage();
    }

    /**
     * Method do fail login.
     *
     * @return return this.
     */
    public SignUpPage doFailLogin() {
        enterUserEmail("admin@admin.ru");
        enterPassword("admin1");
        clickOnLoginButton();

        return new SignUpPage();
    }

    /**
     * Method do log out.
     *
     * @return new SignUpPage().
     */
    public SignUpPage doLogout() {
        PERSONAL_AREA.waitUntil(enabled, DELAY_FOR_WAIT).click();
        LOGOUT_LINK.waitUntil(enabled, DELAY_FOR_WAIT).click();

        return new SignUpPage();
    }

}
