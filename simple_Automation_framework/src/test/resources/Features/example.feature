
@Example
Feature: Login feature

Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid username and password
    And clicks on login button
    Then user should be redirected to the home page
    When user clicks Add to cart on the first Product
    Then Shoping cart icon shows 1 
    When user clicks shoping cart and click checkout 
    Then checkout Form displays 
    When user enters information, clicks continue
    And clicks finish 
    Then A message that says -Thank you for your order- displays
    
