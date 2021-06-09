package MyTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\resources", //the path of the feature files
		glue={"StepDefinitions"}
		)

public class TestRunner {

}
