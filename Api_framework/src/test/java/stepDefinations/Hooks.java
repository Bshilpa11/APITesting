package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScanario() throws IOException {
		
		PlaceApiStepDefination st = new PlaceApiStepDefination();
		if(PlaceApiStepDefination.placeID==null) {
		st.add_place_Payload_with("Andy", "Urdu", "Hydrabad");
		st.user_calls_using_http_request("AddPlaceAPI", "POST");
		st.verify_using_place_id_whether_is_same_as_with("Andy", "GetPlaceAPI");
	}
}
}