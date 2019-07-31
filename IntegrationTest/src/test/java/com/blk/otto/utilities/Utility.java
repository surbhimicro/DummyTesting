package com.blk.otto.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class Utility {
	
	public static RequestSpecification request;
	public static Response response =null;
	ValidatableResponse json;
	public static RequestSpecBuilder rsb=new RequestSpecBuilder();
	
	public static String bodyasString;

	public static InputStream inpStream = null;
	public static Properties prop=new Properties(); 
	
	public Utility()
	{   //Arrange
		rsb.setContentType(ContentType.JSON); 
		request =RestAssured.given().spec(rsb.build());
		
	}
	
	public void readConfigProperty () throws IOException
	{
		try {
			inpStream = this.getClass().getResourceAsStream("com/blk/otto/TestData/Config/config.properties");
			prop.load(inpStream);
		} finally {
			inpStream.close();
		}
        
        
	}
	
	public String Url()
	{
		String url=prop.getProperty("getapiurl");
		return url;
	}
	
	/** performing get call with url
	 * @param url
	 * @return
	 */
	public static ResponseOptions<Response> performGetCall(String url) 
	{
		 try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		return null;
			
	}

	/** performing get call with url and headers
	 * @param url
	 * @param headers
	 * @return
	 */
	public static ResponseOptions<Response> performGetCall(String url, Map<String, String> headers) 
	{
		 try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		return null;
			
	}
}
