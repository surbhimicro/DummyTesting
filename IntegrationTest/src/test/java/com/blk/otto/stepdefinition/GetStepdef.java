package com.blk.otto.stepdefinition;

import org.junit.Assert;
import com.blk.otto.utilities.ConstantConfig;
import com.blk.otto.utilities.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;


public class GetStepdef {
	
	public static ResponseOptions<Response> response;
	private String url ;
	private String s;
	Utility ulty;
 
	
	/** Call before each scenario
	 * Utility Class Declaration  
	 */
	@Before
	public void setup() {
		
		 ulty=new Utility();
		System.out.println("Before");
	}
	

	// Call after each scenario
	  
	@After
	public void cleanup() {
		System.out.println("After");
	}

	
	/**Getting api url from ConstantConfig class
	 * @throws Throwable
	 */
	@Given("^want to perform get operation$")
	public void perform_get_operation_for() throws Throwable 
	{
		url= ConstantConfig.getapiurl;  
		
	}
	
	/** Calling getop method from Utility class
	 * Capturing response in "response" variable
	 * Validating the content of body
	 * @throws Throwable
	 */
	@When("^execute get api$")
	public void execute_get_api() throws Throwable {
		
		response = Utility.performGetCall(url);
		
	}

	/**Passing the id from feature file
	 * @param id
	 * @throws Throwable
	 * Validating the expected and actual result
	 */
	@Then("^should see the circuitId \"([^\"]*)\"$")
	public void should_see_the_circuitId(String id) throws Throwable {
		s = response.getBody().jsonPath().get("data.id").toString();
		
		Assert.assertTrue(s.contains(id));
		
		int code =response.getStatusCode();
		
		System.out.println("Status Code   "  + code);
	}

}
