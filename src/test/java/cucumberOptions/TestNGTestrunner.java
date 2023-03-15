package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="stepDefinition", monochrome=true, tags="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt"})//dryRun=true is for demo run only 
public class TestNGTestrunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}


/*
For extent report follow below steps:

1- add dependency for extent reports
2-add dependency for extent report for cucumber adapter provided by grasshopper
3- add plugin "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" in testRunner file
4-create a properties file and provide below details there 
basefolder.name=test-output/ExtentReport
basefolder.datetimepattern=d-MMM-YY HH-mm-ss
extent.reporter.spark.start=true
extent.reporter.spark.out=test-output/SparkReport/Spark.html
screenshot.dir=test-output/SparkReport/screenshots
screenshot.rel.path=./screenshots/
*/
 