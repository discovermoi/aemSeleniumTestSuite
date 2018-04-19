Feature: Login to an ame instance

  Scenario: Test Login with valid credentials
    Given Open browser and start the aem instance
    When I enter valid username and valid password
    Then user should be able to login successfully