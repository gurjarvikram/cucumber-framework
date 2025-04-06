package cucumberOptions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//html,xml, json, junit, extent Reports

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepsDefinitions",
monochrome=true, plugin= {"html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	static {
        try {
            File reportRoot = new File("test-output");
            File[] reportDirs = reportRoot.listFiles((dir, name) -> name.startsWith("ExtentReport"));

            if (reportDirs != null) {
                for (File dir : reportDirs) {
                    FileUtils.deleteDirectory(dir);
                    System.out.println("✅ Deleted old report folder: " + dir.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ Failed to delete old Extent report folders.");
        }
    }
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
