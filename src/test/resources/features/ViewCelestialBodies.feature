@ViewCelestialBodies
Feature: ViewCelestialBodies

	@REV-TC-16 @JREQ-REV-25
	Scenario: Positive scenario view celestial bodies
	Given a valid username and password, a user should be able to view planets and moons
		Given The user is logged in
		Then The user should view celestial bodies page

	@REV-TC-17 @JREQ-REV-26
	Scenario: Negative Scenario unauthenticated user
	Given an unauthenticated user, attempting to view celestial bodies should prompt for login.
		Given The user is not logged in
		Then The user should not view celestial bodies page