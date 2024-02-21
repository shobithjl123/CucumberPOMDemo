package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.awt.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features"
        ,glue = "stepDefinition"
        ,tags = "@hotelsSearch2"
        ,plugin = {"pretty","html:target/cucumber.html"}
)
public class TestRunner {

}
