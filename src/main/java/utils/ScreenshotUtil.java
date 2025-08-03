package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshotOnFailure(WebDriver driver, String scenarioName) {
        if (driver == null) return;

        String fileName = scenarioName.replaceAll("[^a-zA-Z0-9\\-]", "_") + ".png";
        String screenshotDir = "test-output/screenshots";
        String screenshotPath = screenshotDir + "/" + fileName;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();
            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);

            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ExtentManager.getTest().fail("Scenario failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Screenshot").build());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}