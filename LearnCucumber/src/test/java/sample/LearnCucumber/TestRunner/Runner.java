package sample.LearnCucumber.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/sample/LearnCucumber/Features", glue={"sample.LearnCucumber.TestDefinitions"})
public class Runner {
	
}
