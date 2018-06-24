@Login
Feature: eCommerce Login 


@chrome @firefox
Scenario Outline: Successful Login with Valid Credentials 
	Given User navigates to OSCommerce HomePage 
	Then User navigates to account page
	When User enters valid "<emailAddress>" and "<password>" 
	And User click on Sign In button 
	Then User should arrive to account page 
	
	Examples: 
		|emailAddress | password |
		|applicationtesttt@gmail.com |	ninjas |
		
@chrome @firefox		
Scenario Outline: Unsuccessful Login with Invalid Credentials 
	Given User navigates to OSCommerce HomePage
	Then User navigates to Account Page 
	When User enters invalid "<EmailAdress>" and "<Password>" 
	And User clicks on Sign In button 
	Then User should recieve error message 
	
	Examples: 
		|EmailAddress | Password|
		|userid@gmail.com | password1|
		|test@email.com | password2 |
