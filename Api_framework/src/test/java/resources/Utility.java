package resources;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {
	public static RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	public io.restassured.specification.RequestSpecification RequestSpecification() throws IOException 
	
	{
		if(requestSpec==null) 
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

		 requestSpec = new RequestSpecBuilder() 
				.setBaseUri(getGlobalValue("baseUrl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.build();
		 return requestSpec;
	}
		return requestSpec;
	}
	public io.restassured.specification.ResponseSpecification ResponseSpecification() {

		responseSpec =  new ResponseSpecBuilder() 
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		return responseSpec;
	}
	
	public String getGlobalValue(String KeyValue) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\parsh\\eclipse-workspace\\Api_framework\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(KeyValue);
	}
	
	public String getJasonPath(Response response, String keyValue)
	{
		String res = response.asString();
	    JsonPath j = new JsonPath(res);
	    return j.get(keyValue).toString();
	}
	
	
	
}
