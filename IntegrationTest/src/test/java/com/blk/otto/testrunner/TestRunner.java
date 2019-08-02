package com.blk.otto.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features= {"classpath:Post.feature"}
features = {"src/test/resources/com/blk/otto/Features/Put.feature"} //, "src/test/resources/com/blk/otto/Features/Get.feature"}
,glue= {"classpath:com.blk.otto.stepdefinition"}
,plugin=  {"pretty"},
monochrome= true,
tags = {"@DummyPUTTC05"}

)

public class TestRunner {
	
	

}

