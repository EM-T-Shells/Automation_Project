@RemovePlanets
Feature: RemovePlanets

	@REV-TC-25 @JREQ-REV-40
	Scenario: Positive Scenario Remove Planet
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides a planet name: "UmbrabilisOrchisExquisiteThrow"
		When The user clicks the Delete button
		Then The planet, "UmbrabilisOrchisExquisiteThrow", should be removed from the planetarium

	@REV-TC-26 @JREQ-REV-84 @JREQ-REV-41
	Scenario Outline: Negative Scenario User does not own planet
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides a planet name: "<unowned planet name>"
		When The user clicks the Delete button
		Then The planet should fail to be deleted

		Examples:
			| unowned planet name |
			| Kazuha              |

	@REV-TC-27 @JREQ-REV-42
	Scenario Outline: Negative Scenario Removing non-existing planet
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides a planet name: "<non-existing planet>"
		When The user clicks the Delete button
		Then The planet should fail to be deleted

		Examples:
			| non-existing planet |
			| Mercury             |