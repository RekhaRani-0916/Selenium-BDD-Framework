package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // path to your Product.feature
        glue = {"stepdefinitions", "hooks"},  
        plugin = {"pretty"}, // optional additional HTML report	
        monochrome = true                                       // clean console output
)


public class TestRunner {
    
}
