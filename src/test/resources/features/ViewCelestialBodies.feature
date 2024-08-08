@ViewCelestialBodies
Feature: ViewCelestialBodies

	@REV-TC-16 @JREQ-REV-25
	Scenario Outline: Positive scenario view celestial bodies
		Given The user is logged in with username "<Valid Username>" and password "<Valid Password>"
		Then The user should view celestial bodies page

	Examples: 
		| Valid Username | Valid Password |
		| CarlSagan      | Cosmos@2024    |

	@REV-TC-17 @JREQ-REV-26
	Scenario: Negative Scenario unauthenticated user
		Given The user is not logged in
		Then The user should not view celestial bodies page