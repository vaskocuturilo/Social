package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * An Class smoke pages.
 */

@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class SmokePages extends Pages {

    /**
     * Constant DELAY_FOR_WAIT.
     */
    private static final int DELAY_FOR_WAIT = 5000;

    /**
     * Constant VERIFY_EMAIL.
     */
    private static final String VERIFY_EMAIL = " Please verify your email before you can reset your password. ";

    /**
     * Constant ASSERT_SPORTAMIX_TEXT.
     */
    private static final String ASSERT_SPORTAMIX_TEXT = "Sportamix has revolutionized networking in the sports industry by offering direct communication between athletes, coaches, recruiters, and fans around the world.";

    /**
     * Constant ASSERT_SPORTAMIX_PROFILE.
     */
    private static final String ASSERT_SPORTAMIX_PROFILE = "Why should I create a Sportamix profile?";

    /**
     * Constant EMPTY_EMAIL.
     */
    private static final String EMPTY_EMAIL = " Email can not be empty! ";

    /**
     * Values.
     */
    private static final SelenideElement
            LINK_FORGOT_PASSWORD = $("a[onclick='OpenModalForgotPassword()']"),
            MODAL_WINDOW_FORGOT_PASSWORD = $("div[id='forgotPasswordModal']"),
            NOTIFICATIONS_MESSAGE = $("div.k-notification-wrap"),
            FIELD_EMAIL = $("input[id='forgotPassword-Email']"),
            RESET = $("button[id='forgot-password-button-switch']"),
            REGISTER_NOW = $("a[onclick='RegisterNow()']"),
            MAIN_FORM = $("form[id='form_main']"),
            ATHLETE_BUTTON = $("input[id='userType1']"),
            COACH_BUTTON = $("input[id='userType2']"),
            SPORT_INPUT = $("div[id='registration_sport_container']"),
            FIRST_NAME_FIELD = $("input[id='first_name']"),
            LAST_NAME_FIELD = $("input[id='last_name']"),
            EMAIL_FIELD = $("input[id='email']"),
            PASSWORD_FIELD = $("input[id='new_password']"),
            CONFIRM_PASSWORD_FIELD = $("input[id='confirm_password']"),
            REGISTER_BUTTON = $("button[id='send_main_form']"),
            MAIN_TEXT = $("#tg-wrapper h1"),
            SPORTAMIX_TEXT = $("#tg-wrapper div.rsABlock.txtCent.tg-description p"),
            ABOUT_US_LINK = $("#tg-navigation > ul.navbar-left > li:nth-child(2) a"),
            ABOUT_US_TEXT = $("#tg-wrapper h1"),
            JOIN_NOW_BUTTON = $("a[href='/#registration']"),
            FAQ_LINK = $("#tg-navigation > ul.navbar-left > li:nth-child(3) a"),
            FAQ_TEXT = $("#tg-wrapper h1"),
            SPORTAMIX_PROFILE = $("#athletes div:nth-child(1) div.title");

    /**
     * Default constructor.
     */
    public SmokePages() {
        super();
        //empty constructor
        return;
    }

    /**
     * Method assert registration.
     *
     * @return this.
     */
    public SmokePages doCheckRegistration() {
        REGISTER_NOW.click();
        MAIN_FORM.shouldBe(Condition.enabled);
        MAIN_FORM.shouldHave(text("Let's Start"));
        ATHLETE_BUTTON.shouldBe(Condition.enabled);
        COACH_BUTTON.shouldBe(Condition.enabled);
        SPORT_INPUT.shouldBe(Condition.enabled);
        FIRST_NAME_FIELD.shouldBe(Condition.enabled);
        LAST_NAME_FIELD.shouldBe(Condition.enabled);
        EMAIL_FIELD.shouldBe(Condition.enabled);
        PASSWORD_FIELD.shouldBe(Condition.enabled);
        CONFIRM_PASSWORD_FIELD.shouldBe(Condition.enabled);
        REGISTER_BUTTON.shouldBe(Condition.enabled);

        return this;
    }


    /**
     * Method assert main page.
     *
     * @return this.
     */
    public SmokePages assertMainPage() {
        MAIN_TEXT.shouldHave(text("We Connect"));
        SPORTAMIX_TEXT.shouldHave(text(ASSERT_SPORTAMIX_TEXT));

        return this;
    }

    /**
     * Method assert about us.
     *
     * @return this.
     */
    public SmokePages assertAboutUs() {
        ABOUT_US_LINK.shouldHave(Condition.enabled).click();
        ABOUT_US_TEXT.shouldHave(text("About Us"));
        JOIN_NOW_BUTTON.shouldHave(text("Join now"));
        return this;
    }

    /**
     * Method assert faq.
     *
     * @return this.
     */
    public SmokePages assertFaq() {
        FAQ_LINK.click();
        FAQ_TEXT.shouldHave(text("FAQ"));
        SPORTAMIX_PROFILE.shouldHave(text(ASSERT_SPORTAMIX_PROFILE));
        return this;
    }

    /**
     * Method assert forgot password form.
     *
     * @return this.
     */
    public SmokePages assertForgotPasswordForm() {
        LINK_FORGOT_PASSWORD.click();
        MODAL_WINDOW_FORGOT_PASSWORD.waitUntil(Condition.visible, DELAY_FOR_WAIT).shouldHave(
                text("Enter your email to reset your password"),
                text(" Enter Your Email"),
                text("Cancel"),
                text("Reset"));
        return this;
    }

    /**
     * Method assert unconfirmed forgot password.
     *
     * @param email email.
     * @return this.
     */
    public SmokePages assertUnconfirmed(final String email) {

        FIELD_EMAIL.setValue(email);
        RESET.click();
        NOTIFICATIONS_MESSAGE.waitUntil(Condition.visible, DELAY_FOR_WAIT).shouldHave(text(VERIFY_EMAIL));

        return this;
    }

    /**
     * Method assert non existent forgot password.
     *
     * @param email email.
     * @return this.
     */
    public SmokePages assertNonExistent(final String email) {
        FIELD_EMAIL.setValue(email);
        RESET.click();
        NOTIFICATIONS_MESSAGE.waitUntil(Condition.visible, DELAY_FOR_WAIT).shouldHave(text(VERIFY_EMAIL));

        return this;
    }

    /**
     * Method assert empty email.
     *
     * @param email email.
     * @return this.
     */
    public SmokePages assertEmptyEmail(final String email) {
        FIELD_EMAIL.setValue(email);
        RESET.click();
        NOTIFICATIONS_MESSAGE.waitUntil(Condition.visible, DELAY_FOR_WAIT).shouldHave(text(EMPTY_EMAIL));

        return this;
    }

}


