@Login
Feature: Login

	@REV-TC-11 @JREQ-REV-17
	Scenario Outline: Positive scenario user login
		Given The user navigates to the landing page
		When The user enters username "<Valid Username>"
		When The user enters password "<Valid Password>"
		When The user clicks the login button
		Then The user should be logged in successfully and redirected to homepage

	Examples: 
		| Valid Username | Valid Password |
		| CarlSagan      | Cosmos@2024    |

	@REV-TC-12 @JREQ-REV-18
	Scenario Outline: Negative Scenario Invalid password
		Given The user navigates to the landing page
		When The user enters username "<Valid Username>"
		When The user enters invalid password "<Invalid Password>"
		When The user clicks the login button
		Then The user should be informed that the login failed

	Examples: 
		| Valid Username | Invalid Password |
		| CarlSagan      | Galaxy@2023      |

	@REV-TC-13 @JREQ-REV-19
	Scenario Outline: Negative Scenario Invalid username
		Given The user navigates to the landing page
		When The user enters invalid username "<Invalid Username>"
		When The user enters password "<Valid Password>"
		When The user clicks the login button
		Then The user should be informed that the login failed

	Examples: 
		| Invalid Username  | Valid Password |
		| NeilDegrasseTyson | Cosmos@2024    |

	@REV-TC-14 @JREQ-REV-20
	Scenario Outline: Negative scenario empty username
		Given The user navigates to the landing page
		When The user enters empty username "<Empty Username>"
		When The user enters password "<Valid Password>"
		When The user clicks the login button
		Then The user should be informed that the login failed

	Examples: 
		| Empty Username | Valid Password |
		|                | Cosmos@2024    |

	@REV-TC-15 @JREQ-REV-21
	Scenario Outline: Negative scenario empty password
		Given The user navigates to the landing page
		When The user enters username "<Valid Username>"
		When The user enters empty password "<Empty Password>"
		When The user clicks the login button
		Then The user should be informed that the login failed

	Examples: 
		| Valid Username | Empty Password |
		| CarlSagan      |                |