package utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

@SuppressWarnings({"PMD.LongVariable", "PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class AllureHelpers {

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureTextReport", type = "text/plain", fileExtension = ".txt")
    public static String attachText(String text) {
        return text;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureCSVReport", type = "text/csv", fileExtension = ".csv")
    public static String attachCSV(String csv) {
        return csv;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
    public static byte[] getPageSource() {
        return getPageSourceBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {
        return getScreenshotBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "{name}", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(String name) {
        return getScreenshotBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Element screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot(SelenideElement elem) {
        return getScreenshotBytes(elem);
    }

    public static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static byte[] getScreenshotBytes(SelenideElement elem) {
        return elem.getScreenshotAs(OutputType.BYTES);
    }
}
