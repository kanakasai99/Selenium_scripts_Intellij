package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            reporter.config().setReportName("Screenshot Test Report");
            reporter.config().setDocumentTitle("Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Sai");
        }
        return extent;
    }

    public static ExtentTest createTest(String name) {
        test = getExtentReports().createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReports() {
        if (extent != null) extent.flush();
    }
}