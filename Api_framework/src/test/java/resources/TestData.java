package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Add_payload_pojo;
import pojo.Location_pojo_class;

public class TestData {

	public Add_payload_pojo addPlacePayload(String name1, String lang, String adrs) {
		
		Add_payload_pojo ap =new Add_payload_pojo();
		ap.setAccuracy(50);
		ap.setAddress(adrs);
		ap.setName(name1);
		ap.setLanguage(lang);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		
		List<String> type_list = new ArrayList<String>(); 
		type_list.add("shoe park"); 
		type_list.add("shop");
		ap.setTypes(type_list); 
		
		Location_pojo_class l = new Location_pojo_class();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l); 
		return ap;
	}
	
	public String deletePlacePayload(String placeID)
	{
		return "{\r\n\"place_id\": \""+placeID+"\"\r\n}"; 
	} 
}
