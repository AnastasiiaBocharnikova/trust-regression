package com.trust.cucumber.runnerClass;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src//test//resources//Features//",
        tags = "@Nastya",
        plugin="pretty",
        glue = {"com.trust.cucumber.stepDefs"}
        )

public class runnerClass {

	
}
 