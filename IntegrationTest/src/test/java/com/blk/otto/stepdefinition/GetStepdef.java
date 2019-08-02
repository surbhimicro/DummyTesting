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

	private static ResponseOptions<Response> response;
	private String url;
	private String val;
	Utility ulty = new Utility();

	private static boolean beforeSuit = true;

	@Before
	public void beforeAll() {
		if (beforeSuit) {
			
			System.out.println("Before");
			beforeSuit =false;
			}
	}
	/**
	 * Getting api url from config.properties and ConstantConfig class
	 * 
	 * @throws Throwable
	 */
	@Given("^want to perform get operation$")
	public void perform_get_operation_for() throws Throwable {
		url = ulty.getUrl() + ConstantConfig.suffixgetapiurl;
	}

	/**
	 * Calling getop method from Utility class Capturing response in "response"
	 * variable
	 * 
	 * @throws Throwable
	 */
	@When("^execute get api$")
	public void execute_get_api() throws Throwable {

		response = Utility.performGetCall(url);

	}

	/**
	 * Passing the id from feature file
	 * 
	 * @param id
	 * @throws Throwable Validating the expected and actual result
	 */
	@Then("^should see the circuitId \"([^\"]*)\"$")
	public void should_see_the_circuitId(String id) throws Throwable {
		val = response.getBody().jsonPath().get("data.id").toString();

		Assert.assertTrue(val.contains(id));

		int code = response.getStatusCode();

		System.out.println("Status Code   " + code);
	}

	/**
	 * Performing for Negative Scenario
	 * 
	 * @throws Throwable
	 */
	@Given("^perform get operation$")
	public void perform_get_operation() throws Throwable {
		url = ulty.getUrl() + ConstantConfig.sufinvalidapiurl;
	}

	/**
	 * Calling getop method from Utility class Capturing response in "response"
	 * variable
	 * 
	 * @throws Throwable
	 */
	@When("^execute get api with invalid data$")
	public void execute_get_api_with_invalid_data() throws Throwable {

		response = Utility.performGetCall(url);

	}

	/**
	 * Validating for Negative scenario
	 * 
	 * @throws Throwable Validating the expected and actual result
	 */
	@Then("^should be invalid status$")
	public void should_be_invalid_status() throws Throwable {
		val = response.getBody().jsonPath().get("error").toString();

		System.out.println("Error is   " + val);
		int code = response.getStatusCode();

		Assert.assertNotSame(val, code);
		System.out.println("Status Code  " + code);
	}

}
