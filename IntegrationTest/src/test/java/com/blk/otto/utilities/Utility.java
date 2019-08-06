package com.blk.otto.utilities;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
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
	 * @return ResponseOptions<Response>
	 */
	public static ResponseOptions<Response> performPutCall(String baseURL, String body, Map<String, String> header) {

		RestAssured.baseURI = baseURL;
		return (RestAssured.given().body(body).put(ConstantConfig.suffixputapiurl));
	}

	public <T> Object mapResponseToClass(Class<T> value, String response) {
		ObjectMapper obj = new ObjectMapper();
		try {
			return obj.readValue(response, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public HashMap<String, String> getRequestParameters(String testCaseId, String className) {
		HashMap<String, String> rowMap = new HashMap<String, String>();
		try {
			String sheetName = className.substring(className.lastIndexOf(".") + 1);
			System.out.println(sheetName);
			ClassLoader classLoader = getClass().getClassLoader();
			File f1 = new File(classLoader.getResource("com//blk/otto/TestData//RequestData.xlsx").getFile());
			FileInputStream inputStream = new FileInputStream(f1);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = null;
			int rowIndex = 0;
			for (rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				row = sheet.getRow(rowIndex);
				int cellValue = (int) row.getCell(0).getNumericCellValue();

				if (cellValue == Integer.parseInt(testCaseId)) {
					break;
				}
			}

			int colNo = row.getPhysicalNumberOfCells();
			for (int i = 1; i < colNo; i++) {
				String colName = sheet.getRow(0).getCell(i).getStringCellValue().toString();
				String colValue = sheet.getRow(rowIndex).getCell(i).getStringCellValue().toString();
				rowMap.put(colName, colValue);
			}
			wb.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowMap;
	}
}
