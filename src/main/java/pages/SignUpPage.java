package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * An Class Sign up page.
 */
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize"})
public class SignUpPage extends LoginPage {
    /**
     * Constant DELAY_FOR_WAIT.
     */
    private static final int DELAY_FOR_WAIT = 5000;

    /**
     * List selenide elements.
     */
    private final List<SelenideElement>
            dropDownPost = $$("#news-feed-container > div > div.panel-heading > table > tbody > tr.news-post-container > td > div.dropdown.newsPostDropdown > i"),
            buttonDeletePost = $$("button[onclick='RemoveNewsPost(this)']"),
            postField = $$("div[id='news-feed-container']");
    /**
     * SelenideElements.
     */
    private final SelenideElement
            userName = $("#navbar-mobile li.dropdown.dropdown-user span"),
            alertMessage = $("div.k-notification-wrap"),
            allHeaders = $("div[id='left-menu']"),
            followersLink = $x("//a[contains(.,'Followers')]"),
            followingLink = $("#following-content-menu"),
            followersGrid = $("div[id='grid_followers'"),
            followingGrid = $("div[id='grid_following'"),
            newsFeed = $("body > div.page-container"),
            openPost = $("#news-feed-container tr:nth-child(1) > td.vertical-align-center > span"),
            textAreaForPost = $("#post_text"),
            buttonPost = $("#submitPost"),
            addPostComment = $("input[id*='txtAddPostComment']"),
            buttonComment = $("button[onclick='SubmitPostComment(this)']"),
            myProfileDataCoach = $("div.panel-heading.no-padding-bottom.no-margin"),
            myVideosCoach = $("div:nth-child(5) div.panel-heading.no-padding-bottom"),
            myPhotosCoach = $("div:nth-child(6) > div.panel-heading.no-padding-bottom"),
            myProfileDataAthlete = $("div:nth-child(4) > div.panel-heading.no-padding-bottom"),
            myHighLightVideosAthlete = $("div:nth-child(5) > div.panel-heading.no-padding-bottom"),
            myVideosAthlete = $("div:nth-child(6) > div.panel-heading.no-padding-bottom"),
            myPhotosAthlete = $("div:nth-child(7) > div.panel-heading.no-padding-bottom"),
            myInstagramFeed = $("div[id='instagram-photos'] h5"),
            messagesAthlete = $("#left-menu > a:nth-child(3)"),
            gridMyInbox = $("div.col-sm-5.messages-top-heading-wrapper"),
            contactListMessages = $("div[id='message_contacts_list_container']"),
            myNetwork = $("#left-menu > a:nth-child(4)"),
            gridMyNetwork = $("#grid_mynetwork div.k-grid-content.k-auto-scrollable table"),
            openingsAthlete = $("#left-menu > a:nth-child(5)"),
            gridOpeningsAthlete = $("div.above-kendo"),
            gridTable = $("#grid_openings > table"),
            gridActions = $("#grid_openings tr:nth-child(1) td.cell-actions.col-lg-4.hidden-on-mobile.opening-action-col"),
            messagesCoach = $("#left-menu > a:nth-child(3)"),
            searchTalents = $("#left-menu > a:nth-child(5)"),
            gridSearchTalents = $("div.above-kendo.no-padding"),
            searchTalentsSportPicker = $("input[name='search-talent-sportpicker_input']"),
            searchTalentsAccountTypes = $("#search-talent-account-types_taglist"),
            searchTalentsCountries = $("#search-countries_taglist"),
            favorites = $("#left-menu > a:nth-child(6)"),
            gridFavorites = $("div.above-kendo.favorites-wrap"),
            searchResultGrid = $("#search-results-grid"),
            displayAllDropDown = $("div.above-kendo.favorites-wrap td:nth-child(1) > span"),
            gridOpeningsCoach = $("div[id='no-records']"),
            myProfile = $("a.left-menu-item:nth-child(1)"),
            addTimeLifeEvents = $("span[onclick='AddTimelineEvents()']"),
            addTitleLifeEvents = $("input[id='timeline-event-title']"),
            addDescriptionLifeEvents = $("textarea[id='timeline-event-description']"),
            addTimeLineEvent = $("button[onclick='AddTimelineEvent();']"),
            notifyMessage = $("div[role='alert'] div.notify-message-wrap"),
            titleLifeEvents = $("#timeEvents > div:nth-child(2) span"),
            removeTimeLineEvent = $("button[onclick='RemoveTimelineEvent()']"),
            agreeDeleteMessage = $("body button.ui-pnotify-action-button.btn.btn-sm.btn-delete"),
            myOpenings = $x("//a[contains(.,'My Openings')]"),
            newOpenings = $("#no-records td.align-right button"),
            minAgeOpening = $("input[id='opening-minage']"),
            maxAgeOpening = $("input[id='opening-maxage']"),
            descriptionOpening = $("textarea[id='opening-description']"),
            saveOpening = $("button[id='btnSaveCreateOpening']"),
            deleteOpening = $("td.cell-actions.col-lg-4.hidden-on-mobile > button.btn.btn-default.delete-opening"),
            confirmDeleteOpening = $("button.ui-pnotify-action-button.btn.btn-sm.btn-delete");

    /**
     * Default constructor.
     */
    public SignUpPage() {
        super();
        //empty constructor
        return;
    }

    /**
     * Method assert user name.
     *
     * @param name name user.
     * @return return this.
     */
    public SignUpPage doAssertFirstNameUser(final String name) {
        userName.shouldHave(text(name));

        return this;
    }

    /**
     * Method do it add life event.
     *
     * @param title       title.
     * @param description description.
     * @return return this.
     */
    public SignUpPage doAddLifeEvent(final String title, final String description) {
        myProfile.click();
        addTimeLifeEvents.click();
        addTitleLifeEvents.setValue(title);
        addDescriptionLifeEvents.setValue(description);
        addTimeLineEvent.click();
        notifyMessage.shouldHave(text("Timeline event is created!"));

        return this;
    }

    /**
     * Method do it add openings.
     *
     * @return return this.
     */
    public SignUpPage doAddOpenings() {
        myOpenings.click();
        newOpenings.click();
        minAgeOpening.setValue("13");
        maxAgeOpening.setValue("93");
        descriptionOpening.setValue("Autotest ");
        saveOpening.click();
        notifyMessage.shouldHave(text("Opening created!"));
        gridTable.shouldHave(
                text("Creation Date"),
                text("Expiry Date"),
                text("Description"),
                text("Age"),
                text("Position"),
                text("Actions"),
                text(" View"),
                text(" Edit"),
                text(" Delete"),
                text(" Description Autotest "),
                text("13 - 93"),
                text("All positions"),
                text(" View"), text(" Edit"), text(" Delete"));

        return this;
    }


    /**
     * Method do it assert life event.
     *
     * @param nameLifeEvent name user.
     * @return return this.
     */
    public SignUpPage doAssertLifeEvent(final String nameLifeEvent) {
        titleLifeEvents.shouldHave(text(nameLifeEvent)).click();
        removeTimeLineEvent.waitUntil(enabled, DELAY_FOR_WAIT).click();
        agreeDeleteMessage.waitUntil(enabled, DELAY_FOR_WAIT).click();
        notifyMessage.shouldHave(text("Timeline event deleted!"));

        return this;
    }

    /**
     * Method doFollowers.
     *
     * @param firstName name user.
     * @return this.
     */
    public SignUpPage doFollowers(final String firstName) {

        followersLink.waitUntil(visible, DELAY_FOR_WAIT).click();
        followersGrid.waitUntil(visible, DELAY_FOR_WAIT).shouldHave(text(firstName));

        return this;
    }

    /**
     * Method doFollowing.
     *
     * @param firstName first name.
     * @return this.
     */
    public SignUpPage doFollowing(final String firstName) {

        followingLink.waitUntil(visible, DELAY_FOR_WAIT).click();
        followingGrid.waitUntil(visible, DELAY_FOR_WAIT).shouldHave(text(firstName));

        return this;
    }

    /**
     * Method do Check Coach Profile.
     *
     * @return this.
     */
    public SignUpPage doAssertCoachProfile() {

        $(byText("My Profile")).click();
        myProfileDataCoach.shouldHave(text("Profile data"));
        myProfileDataCoach.scrollTo();
        myVideosCoach.shouldHave(text("Videos"));
        myPhotosCoach.shouldHave(text("Photos"));
        myInstagramFeed.shouldHave(text("Instagram Feed"));

        return this;
    }

    /**
     * Method do Check Athlete Profile.
     *
     * @return this.
     */
    public SignUpPage doCheckAthleteProfile() {
        $(byText("My Profile")).click();
        myProfileDataAthlete.shouldHave(text("Profile data"));
        myProfileDataAthlete.scrollTo();
        myHighLightVideosAthlete.shouldHave(text("Highlights Videos"));
        myVideosAthlete.shouldHave(text("Videos"));
        myVideosAthlete.scrollTo();
        myPhotosAthlete.shouldHave(text("Photos"));
        myInstagramFeed.shouldHave(text("Instagram Feed"));

        return this;
    }

    /**
     * Method check all information on the athlete page.
     *
     * @param text text.
     * @return this.
     */
    public SignUpPage doCheckAthletePageInformation(final String text) {
        messagesAthlete.click();
        gridMyInbox.shouldHave(text("MY INBOX"));
        contactListMessages.shouldHave(text("James Smith "));
        myNetwork.click();
        gridMyNetwork.shouldHave(text(text));
        openingsAthlete.click();
        gridOpeningsAthlete.shouldHave(text("ROSTER OPENINGS"));
        gridTable.shouldBe(enabled);
        gridTable.shouldHave(
                text("Date"),
                text("Author"),
                text("Country"),
                text("Age"),
                text("Position"),
                text("Actions"));
        gridActions.shouldHave(text(" View"), text("Reply"));

        return this;
    }

    /**
     * Method check all information on the coach page.
     *
     * @param text text.
     * @return this.
     */
    public SignUpPage doAssertCoachPageInformation(final String text) {
        messagesCoach.click();
        gridMyInbox.shouldHave(text("MY INBOX"));
        contactListMessages.shouldHave(text("John Smith"));
        myNetwork.click();
        gridMyNetwork.shouldHave(text(text));
        searchTalents.click();
        gridSearchTalents.shouldHave(text("SEARCH TALENTS"));
        searchTalentsSportPicker.shouldHave(enabled);
        searchTalentsAccountTypes.shouldHave(enabled);
        searchTalentsCountries.shouldHave(enabled);
        favorites.click();
        gridFavorites.shouldHave(text("FAVORITES "));
        searchResultGrid.shouldHave(text("John Smith"));
        displayAllDropDown.shouldHave(enabled);
        myOpenings.click();
        gridOpeningsCoach.shouldHave(
                text("Roster Openings"),
                text("You haven't any Openings yet")
        );

        return this;
    }

    /**
     * Method do delete opening.
     *
     * @return this.
     */
    public SignUpPage doDeleteOpening() {
        deleteOpening.click();
        confirmDeleteOpening.click();
        notifyMessage.shouldHave(text("Opening deleted!"));

        return this;
    }

    /**
     * Method do it post.
     *
     * @param post        post.
     * @param nameMention name of mention.
     * @return this.
     */
    public SignUpPage doPost(final String post, final String nameMention) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDateTime now = LocalDateTime.now();
        openPost.click();
        textAreaForPost.setValue(post + dtf.format(now) + " @");
        $x("//span[contains(.,'" + nameMention + "')]").click();
        buttonPost.click();

        return this;
    }


    /**
     * Method do it mentioned.
     *
     * @param nameMentioned bane of mentioned.
     * @return this.
     */
    public SignUpPage doMention(final String nameMentioned) {
//        openPost.click();
        textAreaForPost.setValue("@");
        $x("//span[contains(.,'" + nameMentioned + "')]").click();
        buttonPost.click();

        return this;
    }

    /**
     * Method do it assert mentioned.
     *
     * @param nameMentioned bane of mentioned.
     * @return this.
     */
    public SignUpPage doAssertMention(final String nameMentioned) {

        newsFeed.shouldHave(text(nameMentioned));
        addPostComment.setValue("").pressEnter();
        buttonComment.click();

        return this;
    }

    /**
     * Method do it assert post.
     *
     * @param post post.
     * @return this.
     */
    public SignUpPage doAssertPost(final String post) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDateTime now = LocalDateTime.now();
        newsFeed.shouldHave(text(post + dtf.format(now)));

        return this;
    }

    /**
     * Method do it comment.
     *
     * @param comment comment.
     * @return this.
     */
    public SignUpPage doComment(final String comment) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDateTime now = LocalDateTime.now();
        addPostComment.setValue(comment + dtf.format(now)).pressEnter();
        buttonComment.click();

        return this;
    }

    /**
     * Method do it assert comment.
     *
     * @param comment comment.
     * @return this.
     */
    public SignUpPage doAssertComment(final String comment) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDateTime now = LocalDateTime.now();
        newsFeed.shouldHave(text(comment + dtf.format(now)));

        return this;
    }

    /**
     * Method do it delete post.
     *
     * @return this.
     */
    public SignUpPage doDeletePost() {

        postField.get(0).scrollTo();
        dropDownPost.get(0).waitUntil(enabled, DELAY_FOR_WAIT).click();
        buttonDeletePost.get(0).click();
        $("button.ui-pnotify-action-button.btn.btn-sm.btn-delete").click();

        return this;
    }

    /**
     * Method do assert athlete menu.
     *
     * @return this.
     */
    public SignUpPage doAssertAthleteMenu() {
        allHeaders.shouldHave(
                text("My Profile"),
                text("News Feed"),
                text("Messages "),
                text("My Network"),
                text("View Openings"));

        return this;
    }

    /**
     * Method do assert coach menu.
     *
     * @return this.
     */
    public SignUpPage doAssertCoachMenu() {
        allHeaders.shouldHave(
                text("My Profile"),
                text("News Feed"),
                text("Messages "),
                text("My Network"),
                text("Search Talents"),
                text("Favorites"),
                text("My Openings"));

        return this;
    }


    /**
     * Method assert entered is incorrect.
     *
     * @param notificationMessage notification message.
     */
    public void assertEnteredIsIncorrect(final String notificationMessage) {

        alertMessage.waitUntil(visible, DELAY_FOR_WAIT).shouldHave(text(notificationMessage));
    }
}
