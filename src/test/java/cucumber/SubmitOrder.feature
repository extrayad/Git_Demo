

Background:
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order.
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmationPage

    Examples: 
      | name          | password    | productName |
      | rny@gmail.com | Learning@24 | ZARA COAT 3 |
    
    
    
