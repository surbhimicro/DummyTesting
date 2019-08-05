package com.blk.otto.stepdefinition;

import org.junit.Assert;

import com.blk.otto.utilities.ConstantConfig;
import com.blk.otto.utilities.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;

public class DeleteStepDef {
	
 
	private static ResponseOptions<Response> response;
	private String URL;
	Hooks hook;
	
	public DeleteStepDef()
	{
		this.hook =new Hooks();
	}
	
	/**
	 * Getting api url from config.properties and ConstantConfig class
	 * 
	 * @throws Throwable
	 */
	@Given("^perform delete operation$")
	public void perform_delete_operation() throws Throwable {
		URL = hook.getBaseUrl("postapiurl") + ConstantConfig.suffixpostapiurl;
	}

	/**
	 * Calling delete call method from Utility class Capturing response in "response"
	 * variable
	 * 
	 * @throws Throwable
	 */
	@When("^execute the delete api$")
	public void execute_the_delete_api() throws Throwable {

		response = Utility.performDeleteCall(URL);
		System.out.println("No response Body.....  " + ((ResponseBodyData) response).asString());

	}

	/**
	 * Validating the expected result
	 * 
	 * @throws Throwable Validating the expected and actual result
	 */
	@Then("^should see no response body$")
	public void should_see_no_response_body() throws Throwable {
		
		int code = response.getStatusCode();
		System.out.println("Status Code   " + code);
		Assert.assertEquals(204, code);

	}

}
