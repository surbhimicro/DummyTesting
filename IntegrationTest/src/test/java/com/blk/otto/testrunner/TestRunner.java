package com.blk.otto.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features= {"classpath:Post.feature"}
features = {"src/test/resources/com/blk/otto/Features"} //, "src/test/resources/com/blk/otto/Features/Get.feature"}
,glue= {"classpath:com.blk.otto.stepdefinition"}
,plugin=  {"json:target/cucumber.json","pretty","html:target/site/cucumber-pretty"},
monochrome= true
//tags = {"@DummyTC01"}

)

public class TestRunner {
	
	

}

