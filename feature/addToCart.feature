@AddItem
Feature: eCommerce Add Item To Cart

@chrome @firefox
Scenario Outline: User Successfully Add An Item To The Cart
	Given UseR Navigates To OSCoMMerce HomEPage 
	Then UseR Navigates TO Account Page
	When UseR Enters ValiD "<EmailAddress>" and "<Password>" 
	And UseR Click on SigN in Button 
	Then UseR Should Arrive To Account Page
	When User clicks on Hardware Tab
	And User selects graphics card tab and select graphic card
	Then User add item to cart
	Then User clicks check out button
	
	
	Examples: 
		|EmailAddress | Password |
		|applicationtesttt@gmail.com |	ninjas |