Feature: Search Functionality
  As a user I want to search for a product
  and get the desired product displayed on the screen.

  Scenario: User searches for the product "Mobile"

    Given the user is on the homepage
    When the user clicks on "phone" in category section
    Then the user should be displayed only "phone"

  Scenario: User searches for the product "Laptop"

    Given the user is on the homepage
    When the user clicks on "laptop" in category section
    Then the user should be displayed only "laptop"