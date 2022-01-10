package resources;

public enum AllAPIResources {

	
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	AllAPIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResourse()
	{
		return resource;
	}
}
