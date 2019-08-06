package com.blk.otto.stepdefinition;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Assert;
import com.blk.otto.utilities.ConstantConfig;
import com.blk.otto.utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;

public class PostStepDef {
	
	private static ResponseOptions<Response> response;
	private String URL;
	private String val;
	Hooks hook;
	Utility utility;
	
	public PostStepDef()
	{
		this.hook =new Hooks();
		utility = hook.getUtilityObject();
	}
	


	/**
	 * Getting api url from config.properties and ConstantConfig class
	 * 
	 * @throws Throwable
	 */
	@Given("^perform post operation$")
	public void perform_post_operation() throws Throwable {
		URL = hook.getPropertyValue("postapiurl") + ConstantConfig.suffixpostapiurl;
	}

	/**
	 * Calling post call method from Utility class Capturing response in "response"
	 * variable
	 * 
	 * @throws Throwable
	 */
	@When("^execute the post api with body \"([^\"]*)\" and \"([^\"]*)\"$")
	public void execute_the_post_api_with_body(String name, String job) throws Throwable {

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("job", job);
		String body = json.toString();
		Map<String, String> header = new HashMap<String, String>();

		header.put("Content-Type", "application/json");
		// header.put("Authorization", props.getproperty("key"));
		response = utility.performPostCall(URL, body, header);

		System.out.println("Body.....  " + ((ResponseBodyData) response).asString());

	}

	/**
	 * Passing the job value from feature file
	 * 
	 * @throws Throwable Validating the expected and actual result
	 */
	@Then("^should see expected result \"([^\"]*)\"$")
	public void should_see_expected_result(String job) throws Throwable {
		val = response.getBody().jsonPath().get("job").toString();

		Assert.assertTrue(val.contains(job));

		int code = response.getStatusCode();
		System.out.println("Status Code   " + code);

		Assert.assertEquals(201, code);

	}

	
	
}
