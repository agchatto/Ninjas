@Logout
Feature: eCommerce Logoff

@chrome @firefox
Scenario Outline: User Successfuly Logoff 
Given User Arrives to Login Page
When User Enters Valid Credentials "<email>" and "<password>"
Then User Arrives to Account Page
Then User Successfully Logoff

Examples:
|email|password|
|applicationtesttt@gmail.com|ninjas|

