package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions

(features="C:\\Users\\Venky\\eclipse-workspace\\cucumberproject\\Features\\Customer.feature",
glue="stepdefinations",
dryRun=false,
monochrome=true,
plugin= {"pretty","html:test-output"}

)

public class TestRun {
	
	

}
