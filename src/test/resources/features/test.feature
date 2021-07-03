Feature: Search weather in your city
  I want to search weather in my city

  @tag1
  Scenario: Search weather with valid city name
    Given I want to search weather in Ho Chi Minh
    Then I should get the status code is 200
    And I should get the response relevant: Ho Chi Minh
    And I want to print out the weather status
    
  Scenario: Search weather with valid city name and country code
    Given I want to search weather in Ha Noi, VN
    Then I should get the status code is 200
    And I should get the response relevant: Ha Noi, VN
    And I want to print out the weather status
    
  Scenario: Search weather with invalid city name
    Given I want to search weather in Invalid Name
    Then I should get the status code is 404
    And I should get the message with: city not found
    
  Scenario: Search weather with valid city name and invalid country code
    Given I want to search weather in Ha Noi, US
    Then I should get the status code is 404
    And I should get the message with: city not found

	Scenario: Search weather with empty
    Given I want to search weather in ""
    Then I should get the status code is 404
    And I should get the message with: city not found
    
  Scenario: Search weather with keyword less than three characters
    Given I want to search weather in Ha
    Then I should get the status code is 404
    And I should get the message with: city not found
    
  Scenario: Search weather with invalid api key
    Given I search weather in London with invalid app id
    Then I should get the status code is 401
    And I should get the message with: Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.