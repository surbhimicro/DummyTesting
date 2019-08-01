package com.blk.otto.utilities;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;
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
	public static InputStream inpStream = null;
	public static Properties prop = new Properties();
	private String url;

	/**
	 * Constructor Initialization done for Rest assured
	 */
	public Utility() { // Arrange
		rsb.setContentType(ContentType.JSON);
		request = given().spec(rsb.build());

	}

	/**
	 * parsing the config.properties file
	 * 
	 * @throws IOException
	 */
	public void readConfigProperty() throws IOException {
		try {
			inpStream = getClass().getClassLoader()
					.getResourceAsStream("com//blk//otto//TestData//Config//config.properties");
			if (inpStream != null)
				prop.load(inpStream);
			else
				throw new RuntimeException("Config file cannot found");
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}
	}

	/**
	 * get url from config.properties file
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getUrl() throws IOException {
		readConfigProperty();
		url = prop.getProperty("getapiurl");
		if (url != null) {
			return url;
		} else
			throw new RuntimeException("url not specified in property file");
	}

	/**
	 * @return post url from config.properties file
	 * @throws IOException
	 */
	public String postUrl() throws IOException {
		readConfigProperty();
		url = prop.getProperty("postapiurl");
		if (url != null) {
			return url;
		} else
			throw new RuntimeException("url not specified in property file");
	}

	/**
	 * performing get call with url
	 * 
	 * @param url
	 * @return
	 */
	public static ResponseOptions<Response> performGetCall(String url) {
		try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
		return null;

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
	 * performing for put call
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

}
