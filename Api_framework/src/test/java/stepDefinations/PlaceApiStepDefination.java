package stepDefinations;


import static io.restassured.RestAssured.given;


import java.io.IOException;


import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import resources.AllAPIResources;
import resources.TestData;
import resources.Utility;

public class PlaceApiStepDefination extends Utility{
	
	RequestSpecification req;
	Response response;
	static String placeID; // To use the same variable value throughout the test making it static.
	
	TestData data = new TestData();

	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_Payload_with(String name, String lang, String adrs) throws IOException {
		
		 req = given().spec(RequestSpecification()) 
		.body(data.addPlacePayload(name,lang,adrs));
	   
	}

	@When("user calls {string} using {string} http request")
	public void user_calls_using_http_request(String resource, String httpMethod) {
		
		
		AllAPIResources resApi = AllAPIResources.valueOf(resource);
		
		if(httpMethod.equalsIgnoreCase("POST"))
		{
			response = req.when().post(resApi.getResourse());
		}
		else { 
			response = req.when().get(resApi.getResourse());
		}
	}

	@Then("API call is successful with status code {int}")
	public void api_call_is_successful_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		 
		Assert.assertEquals(response.getStatusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    Assert.assertEquals(getJasonPath(response, keyValue),ExpectedValue);
	}

	@Then("verify using place_id whether is same as {string} with {string}")
	public void verify_using_place_id_whether_is_same_as_with(String Expected_Name, String resource) throws IOException {
	    
		 placeID = getJasonPath(response, "place_id");
		 req = given().spec(RequestSpecification()).queryParam("place_id", placeID); 
		 user_calls_using_http_request(resource, "GET");
		 String Actual_Name = getJasonPath(response, "name");
		 Assert.assertEquals(Actual_Name, Expected_Name);
		 }


	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
	   
		req = given().spec(RequestSpecification()).body(data.deletePlacePayload(placeID));
	}

}
