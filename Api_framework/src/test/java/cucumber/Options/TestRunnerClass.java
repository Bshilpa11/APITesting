package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		strict = true,
		features="C:\\Users\\parsh\\eclipse-workspace\\Api_framework\\src\\test\\java\\all_features",
		plugin ="json:target/jsonReports/cucumber--reports.json",
		glue = {"stepDefinations"},
		tags = {"@AddPlace"}
		)

	//Adding Class  AbstractTestNGCucumberTests to run cucumber file
public class TestRunnerClass extends AbstractTestNGCucumberTests {

}

