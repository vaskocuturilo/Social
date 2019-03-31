package pages;


import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * An Class Page.
 */
@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class Pages {

    /**
     * Default constructor for class Pages.
     */
    public Pages() {
        super();
        //empty constructor.
        return;
    }

    /**
     * Method open page.
     *
     * @param url link or url.
     * @return return this method.
     */
    public SmokePages openPage(final String url) {
        open(url);

        return new SmokePages();
    }

    /**
     * Method doInstagramImage.
     *
     * @return elements.
     */
    public ElementsCollection doInstagramImage() {

        return $$("ul[id='instagram'] li");
    }

    /**
     * Method doCheckSocialIcons.
     *
     * @return this.
     */
    public ElementsCollection doCheckSocialIcons() {
        return $$("ul[class='tg-socialicons hidden-xs'] li");
    }

    /**
     * Method doCheckSocialIcons.
     *
     * @return this.
     */
    public ElementsCollection doAssertFollowUsSocialIcons() {
        return $$("ul[class='tg-socialicons'] li");
    }
}
