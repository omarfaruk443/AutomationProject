Feature: Google Test Scenarios
  Scenario Outline: TC01b - Capture multiple search result for cities
    Given I am navigating to Google homepage
    When I am entering a keyword <City> on search field
    When I am clicking on Search button
    Examples:
      |City  |
      |Brooklyn|
      |Queens  |
      |Manhattan|



