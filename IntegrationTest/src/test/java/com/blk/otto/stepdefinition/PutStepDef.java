package com.blk.otto.stepdefinition;


import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Assert;
import com.blk.otto.utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;

public class PutStepDef {
	
	private static ResponseOptions<Response> response;
	private String URL;
	Hooks hook;
	Utility utility;
	
	public PutStepDef()
	{
		this.hook =new Hooks();
		utility = hook.getUtilityObject();
	}

	/**
	 * Getting api url from config.properties and ConstantConfig class
	 * 
	 * @throws Throwable
	 */
	@Given("^I want to perform PUT operation$")
	public void perform_put_url_check() throws Throwable {
		//URL = hook.putUrl() + ConstantConfig.suffixputapiurl;
		URL = hook.getPropertyValue("putapiurl");
	}

	/**
	 * Calling put call method from Utility class Capturing response in "response"
	 * variable
	 * 
	 * @throws Throwable
	 */
	@When("^I submit PUT request with body \"([^\"]*)\" and \"([^\"]*)\"$")
	public void execute_the_put_api_with_body(String name, String salary) throws Throwable {

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("salary", salary);
		String body = json.toString();
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		response=utility.performPutCall(URL, body, header);
		System.out.println("<< Response Body=" + ((ResponseBodyData) response).asString()+" >>");		
	}


	/**
	 * Verify PUT response status code
	 * 
	 * @throws Throwable
	 */
	@Then("^I validate status code is \"([^\"]*)\"$" )  
	public void validate_response_StatusCode(int expectedstatuscode) throws Throwable {
		int actualstatuscode=response.getStatusCode();
		try {
			Assert.assertEquals(expectedstatuscode, actualstatuscode);
			System.out.println("<<PUT method status code check : PASS>>" );
		} 
		catch(Exception e) {
			System.out.println("<<PUT method status code check : FAIL>>" );
			e.printStackTrace();
		}
	} 
}
