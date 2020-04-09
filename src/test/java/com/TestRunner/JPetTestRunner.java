package com.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				    features="src/test/resources/JPetFeatures/JPet.feature/", 
				    tags = {"@tc_01_LoginPage, @tc_02_BirdsPage, @tc_03_CatsPage, @tc_04_ReptilesPage,"
				    		+ "@tc_05_DogsPage, @tc_06_FishesPage, @tc_07_ExcelReadLoginPage"},
				    
					glue= "com.StepDefinition",
					
					plugin = {"pretty", "html:target/cucumber-html-report",
							             "json:target/cucumber-json-report",
							             "junit:target/cucumber-junit-report",
							             "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-report/Extentreport.html"}    
				)
public class JPetTestRunner 
{
	
	@AfterClass
	public static void extentreport()
	{
		Reporter.loadXMLConfig("src\\test\\resources\\JPetTestData\\Extent-Config");
		Reporter.setSystemInfo("user",System.getProperty("user.name"));
		Reporter.setSystemInfo("os","Windows");
		Reporter.setTestRunnerOutput("sample test runner output message");
	}

}
