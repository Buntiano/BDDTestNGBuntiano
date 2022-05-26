package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src//test//resources//SampleFeature//GooglePage.feature",
		glue={"stepDef"},
		monochrome=true,
		dryRun=false,
		plugin={
				"pretty",
				"html:target/reports/HtmlReport.html",
				"rerun:target/failed_scenarios.txt",
				}
		
		
		)

public class GooglePageRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true)
	public Object[][] f_Scenarios(){
		return super.scenarios();
	}

}
