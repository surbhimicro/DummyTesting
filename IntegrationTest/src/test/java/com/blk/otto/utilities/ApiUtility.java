package com.blk.otto.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiUtility {
	
	public static RequestSpecification request;
	public static Response response =null;
	ValidatableResponse json;
	public static RequestSpecBuilder rsb=new RequestSpecBuilder();
	
	public static Workbook wb = null;
	public static String filepath="C:/Users/surmitta/Documents/project/IntegrationTest/IntegrationTest/src/test/resources/com/blk/otto/TestData";
	public static String fileName="APIPost.xlsx";
	public static File file =  new File(filepath +"\\" +fileName);
	public static FileInputStream inputStream; 
	public static FileOutputStream outputStream;
	public static Row row;
	public static Cell cell;
	public static Sheet ws;
	public static String bodyasString;
	public static String[][] requestData;
	
	public ApiUtility()
	{   //Arrange
		rsb.setContentType(ContentType.JSON); 
		request =RestAssured.given().spec(rsb.build());
		
	}
	
	public void getopwithparameter(String url, Map<String, String> pathParams) throws URISyntaxException
	{
		//Act
		request.pathParams(pathParams);
		request.get(new URI(url));
		
	}
	
	public ResponseOptions<Response> getop(String url) 
	{
		 try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	
	public static void header()
	{
		Headers allHeaders = response.headers();
		
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 }
	}
	
	public static void postop (String baseURL, String name, String job)
	{
		JSONObject json=new JSONObject();
        json.put("name", name);
        json.put("job", job);
        request.header("Content-Type", "application/json");
     request.body(json.toString());

    
        response=request.post(baseURL);
        bodyasString =response.asString();
        
        System.out.println("Body.....  " +bodyasString);
            
	}
	
	public static String readexcel(int index)
	{
		String baseURI = null;
		try {
			
			 inputStream = new FileInputStream(file);			
			wb = new XSSFWorkbook(inputStream);
 			ws = wb.getSheetAt(index);
 			int rowcount = ws.getLastRowNum() +1;
 			int colcount = ws.getRow(1).getLastCellNum();
 			
 			System.out.println("Total count is...   "  +rowcount +" " +colcount);
 			requestData=new String[rowcount][colcount];
 			
 			System.out.println("Populating Array");
 			for (int i=1; i<rowcount; i++) {
 		         row = ws.getRow(i);
 		        
 		        for (int j=0; j<colcount; j++) {
 		            cell = row.getCell(j);
 		            if(cell!=null)
 		            {
 		            String value = cell.toString();
 		           System.out.println("Value....    "  +value);
 		           requestData[i][j] = value;
 		            }
 		        }   
 		    }
 		    System.out.println("Array population complete");
 		    
 		     baseURI=requestData[1][1];
           
          // System.out.println("baseURI    " +baseURI);
           
          // rsb.setBaseUri(baseURI);
           //rsb.setContentType(ContentType.JSON);
   		//request =RestAssured.given().spec(rsb.build());
//           response =RestAssured.given().header("Content-Length", "84").body(file).with().
//                   contentType("application/json").then().expect().
//
//                   statusCode(201).
//
//                   when().post(baseURI);
           
           //request =RestAssured.given();
        		   //.header("Content-Length", "84");
           
          
//           Assert.assertEquals(code, 201);
//           
//           String successCode = response.jsonPath().get("SuccessCode");
//           Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
           inputStream.close();
           
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return baseURI;
	}
	
	public static void writeintoexcel()
	{
		row = ws.getRow(1); 
        cell = row.createCell(4);
        cell.setCellValue(response.getStatusCode());
        
        cell = row.createCell(7);
   		cell.setCellValue(bodyasString);
      
		 try {
			outputStream = new FileOutputStream(file);
				wb.write(outputStream);
				outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
