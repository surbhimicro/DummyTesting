package com.blk.otto.utilities;

import static io.restassured.RestAssured.given;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Utility {

	public static RequestSpecification request;
	public static Response response = null;
	ValidatableResponse json;
	public static RequestSpecBuilder rsb = new RequestSpecBuilder();
	public static String bodyasString;
	
	

	/**
	 * Constructor Initialization done for Rest assured
	 */
	public Utility() { // Arrange
		rsb.setContentType(ContentType.JSON);
		request = given().spec(rsb.build());

	}

	
	/**
	 * performing get call with url
	 * 
	 * @param url
	 * @return
	 */
	public static ResponseOptions<Response> performGetCall(String url) {
		
		return RestAssured.given().get(url);

	}

	/**
	 * performing get call with url and headers
	 * 
	 * @param url
	 * @param headers
	 * @return
	 */
	public static ResponseOptions<Response> performGetCall(String url, Map<String, String> headers) {
		
		try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * performing for post call
	 * 
	 * @param baseURL
	 * @param body
	 * @param header
	 * @return
	 */
	public static ResponseOptions<Response> performPostCall(String baseURL, String body, Map<String, String> header) {
		request.body(body);
		request.headers(header);
		return request.post(baseURL);

	}
	
	/**
	 * performing for delete call
	 * 
	 * @param baseURL
	 * @return
	 */
	public static ResponseOptions<Response> performDeleteCall(String baseURL) {
		
		return request.delete(baseURL);

	}
	
     /**
     * performing for put call
     * 
      * @param baseURL
     * @param body
     * @param header
     * @return
     */
     public static ResponseOptions<Response> performPutCall(String baseURL, String body, Map<String, String> header) {
           
          RestAssured.baseURI=baseURL;
    	  return (RestAssured.given()
                         .body(body)
                         .put(ConstantConfig.suffixputapiurl));
     }


}
