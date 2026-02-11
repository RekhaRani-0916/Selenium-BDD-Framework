package hooks;

import bases.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;

import java.awt.Desktop;
import java.io.File;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest test;

    // Runs once before all features
    @BeforeAll
    public static void beforeAll() {
        // Initialize ExtentReports
        extent = ExtentReportManager.getInstance();

        // Open browser once
        Base base = new Base();
        base.openBrowser();
    }

    // Runs before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        // Navigate to home page before each scenario
        Base base = new Base();
        base.goToHomePage();

        // Create ExtentTest node for scenario
        test = extent.createTest(scenario.getName());
    }

    // Runs after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario Failed");
            // Optional: add screenshot capture here
        } else {
            test.pass("Scenario Passed");
        }

        // Update HTML report
        extent.flush();
    }

    // Runs once after all features
    @AfterAll
    public static void afterAll() {
        // Close browser at the very end
        Base base = new Base();
        base.closeBrowser();

        // Automatically open the combined HTML report
        try {
            File reportFile = new File("target/BDD_AllFeatures_Report.html");
            if (reportFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(reportFile.toURI());
                } else {
                    System.out.println("Desktop not supported. Open report manually: " + reportFile.getAbsolutePath());
                }
            } else {
                System.out.println("Report file not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
