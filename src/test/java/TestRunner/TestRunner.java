package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/FeatureFiles",
        glue = "StepDefinition",
        dryRun = true,
        monochrome = true,
        plugin = {"pretty"}
)
public class TestRunner {
}
