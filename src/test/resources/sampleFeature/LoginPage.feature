
    


Feature: Login Page


#Scenario Outline:  Valid Login 
#  Given User is on Login Page
  #When User enters Login Credentials
  #When User enters "tomsmith" and "SuperSecretPassword!"
	#When User enters "<username>" and "<password>"
#  Then User is able to navigate to Home Page
 
#Examples: 
#| username | password |
#| tomsmith | SuperSecretPassword! |
#| testuser1 | Welcome1 |
#| testuser2 | Welcome2 |


Scenario: Valid Login
Given User is on Login Page
When User enters Login Credentials
# | tomsmith | SuperSecretPassword! |
| username | password | 
| tomsmith | SuperSecretPassword! |
Then User is able to navigate to Home Page