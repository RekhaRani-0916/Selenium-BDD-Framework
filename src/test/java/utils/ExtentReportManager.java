package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {}

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create a Spark reporter
            ExtentSparkReporter spark = new ExtentSparkReporter("target/BDD_AllFeatures_Report.html");
            spark.config().setDocumentTitle("BDD Automation Test Report");
            spark.config().setReportName("AutomationExercise Test Results");

            // Create ExtentReports and attach reporter
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Optional: add system info
            extent.setSystemInfo("Tester", "Rekha Rani");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
