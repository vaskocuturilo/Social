package utils;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

/**
 * Selenide screenshots to Allure report.
 * <p>
 * Annotate your test class with <code>@Listeners({AllureScreenShooter.class})</code>.
 * <p>
 * You can configure capture screenshots after success tests by <code>AllureScreenShooter.captureSuccessfulTests = false;</code>.
 * <p>
 * Link {@link com.codeborne.selenide.testng.ScreenShooter}
 */
public class AllureScreenShooter extends ExitCodeListener {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        AllureHelpers.takeScreenshot();
    }


}