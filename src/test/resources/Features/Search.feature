Feature: Search Functionality
  As a user I want to search for a product
  and get the desired product displayed on the screen.

  Scenario: User searches for the product "Mobile"

    Given the user is on the homepage
    When the user clicks on "Phone" in category section
    Then the user should be displayed only "Phone"
