package util;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = "stepdef",
    tags = "@Example",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
  
    monochrome = true
)

public class TestRunner {
   
}

