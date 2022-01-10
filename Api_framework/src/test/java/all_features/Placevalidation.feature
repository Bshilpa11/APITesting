Feature: Validating the Place API

	@AddPlace
  Scenario Outline: Verify if the Place is being Successfully added using AddPlaceAPI
    Given Add place Payload with "<Name>" "<Language>" "<Address>"
    When user calls "AddPlaceAPI" using "POST" http request
    Then API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify using place_id whether is same as "<Name>" with "GetPlaceAPI"

    Examples: 
      | Name       | Language | Address            |
      | Sweet Home | Hindi    | Near Ganesh temple |
		# |Perfect Home| Marathi  | Near Big Bazar     |
		
		@DeletePlace
  Scenario: Verify if Delete place functionality is working
    Given Delete place payload
    When user calls "DeletePlaceAPI" using "POST" http request
    Then API call is successful with status code 200
    And "status" in response body is "OK"
