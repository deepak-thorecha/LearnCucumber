Feature: eBay Login
  I want to use this template for my feature file
  
  Background: User is on Login Page 
  Given Browser is opened
  And I am on LoginPage 
  
  Scenario: Check Login functionality
    When I enter username
    And Password 
    And I click signIn button
    Then I check if Login is successful
  
  Scenario Outline: Login with username and password
    When I enter "<userName>" and "<pswd>"
    And I click signIn button 
    Then I check if Login is successful      
	
	Examples:
	| userName  		| pswd 			|
  | testaubasic 	| N0wBuy1t! 	|
  | testauanchor | N0wBuy1t! 	|
  | testaupremium| N0wBuy1t 	|