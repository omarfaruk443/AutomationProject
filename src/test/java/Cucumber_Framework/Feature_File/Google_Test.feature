Feature: Google Test Scenarios

  Scenario: TC01 - Capture Search Result
    Given I navigate to Google homepage
    When I enter a keyword on search field
    When I click on Search button
    When I capture my search result
    Then I print my search number




