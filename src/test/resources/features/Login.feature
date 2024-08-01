@Login
Feature: Login

	@REV-TC-11 @JREQ-REV-17
	Scenario Outline: Positive scenario user login
	Users should be able to securely access their account.
		Given The user navigates to the landing page
		When The user enters username "<Valid Username>"
		When The user enters password "<Valid Password>"
		Then The user should be logged in successfully and redirected to homepage

	Examples: 
		| Valid Username | Valid Password |
		| CarlSagan      | Cosmos@2024    |

	@REV-TC-12 @JREQ-REV-18
	Scenario Outline: Negative Scenario Invalid password
	Given a valid username and invalid password, a user should not be able to log into the Planetarium
		Given The user is on the login page
		When The user enters a username  "<Valid Username>"
		When The user enters a password "<Invalid Password>"
		When The user clicks the login button
		Then The user should be informed that the login failed

	Examples: 
		| InvalidPassword | Valid Username |
		| Galaxy@2023     | CarlSagan      |

	@REV-TC-13 @JREQ-REV-19
	Scenario Outline: Negative Scenario Invalid username
	Given an invalid username and valid password, a user should not be able to log into the Planetarium
		Given The user is on the login page
		When The user enters a "<Invalid Username>"
		When The user enters a "<Valid Password>"
		Then The user should be informed that the login failed

	Examples: 
		| Valid Password | Invalid username  |
		| Cosmos@2024    | NeilDegrasseTyson |

	@REV-TC-14 @JREQ-REV-20
	Scenario Outline: Negative scenario empty username
	Given an empty username and valid password, a user should not be able to log into the Planetarium
		Given The user is on the login page
		When The user enters an "<Empty Username>"
		When The user enters a "<Valid Password>"
		Then The user should be informed that the login failed

	Examples: 
		| Empty username | Valid Password |
		|                | Cosmos@2024    |

	@REV-TC-15 @JREQ-REV-21
	Scenario Outline: Negative scenario empty password
	Given a valid username and empty password, a user should not be able to log into the Planetarium
		Given The user is on the login page
		When The user enters an "<Empty Username>"
		When The user enters a "<Valid Password>"
		Then The user should be informed that the login failed

	Examples: 
		| Empty username | Valid Password | Valid Username | Empty password |
		|                | Cosmos@2024    | CarlSagan      | " "            |