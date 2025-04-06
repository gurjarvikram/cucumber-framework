package stepsDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() {
        testContextSetup.testBase.quitDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            testContextSetup.testBase.takeScreenshot(scenario);
        }
    }    
  

}
