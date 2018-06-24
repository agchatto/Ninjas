package testrunner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@CucumberOptions (
	features = "feature",
	glue = {"stepdefinition/LogOutStepDef", "utility"},
	plugin = { "pretty","html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
	"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
	tags = {"@LogOut"}
	)

@Test
public class LogOutTestRunner extends AbstractTestNGCucumberTests {
		@AfterClass
		public static void writeExtentReport() {
			Reporter.loadXMLConfig(new File("config/loginreport.xml"));
		}

}
