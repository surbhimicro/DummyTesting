package com.blk.otto.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/com/blk/otto/Features/Get.feature"
,glue= {"classpath:com.blk.otto.stepdefinition"}
,plugin=  {"pretty"},
monochrome= true,
//dryRun  = true,
tags = {"@DummyTC01,@Positive"}

)

public class TestRunner {
	

}

