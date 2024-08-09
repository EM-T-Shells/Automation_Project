@AddPlanets
Feature: AddPlanets

	@REV-TC-18 @JREQ-REV-30
	Scenario Outline: Positive Scenario Add Planet with image
	A user should be able to add a new planet with a valid planet name
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides "<valid planet name>" for planet name
		When The user provides a valid planet image
		When The user clicks the Submit Planet button
		Then The "<valid planet name>" planet should be added to the planetarium

		Examples:
			| valid planet name              |
			| UmbrabilisOrchisExquisiteThrow |

	@REV-TC-20 @JREQ-REV-35 @JREQ-REV-32
	Scenario Outline: Negative Scenario Invalid Planet name
	A user should not be able to add a new planet with an invalid planet name
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides "<invalid planet name>" for planet name
		When The user provides a valid planet image
		When The user clicks the Submit Planet button
		Then The "<invalid planet name>" planet should not be added to the planetarium

		Examples:
			| invalid planet name             |
			| Bait-and-Switch Dealers Sleight |
			| Earth                           |

	@REV-TC-22 @JREQ-REV-33
	Scenario: Negative Scenario Empty planet name
	A user should not be able to add a new planet with an empty planet name
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides an empty planet name
		When The user provides a valid planet image
		When The user clicks the Submit Planet button
		Then The empty planet name should not be added to the planetarium

	@REV-TC-23 @JREQ-REV-82 @JREQ-REV-34
	Scenario Outline: Negative Scenario Invalid image format
	A user should not be able to add a new planet with a valid planet name and invalid image format
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides "<valid planet name>" for planet name
		When The user provides an invalid image format
		When The user clicks the Submit Planet button
		Then The "<valid planet name>" planet should not be added to the planetarium

		Examples:
			| valid planet name |
			| Venus             |

	@REV-TC-24 @JREQ-REV-83 @JREQ-REV-36
	Scenario Outline: Positive Scenario Planet added without image
	A user should be able to add a new planet with a valid planet name and no image
		Given The user is logged in
		When The user selects Planet from the drop down menu
		When The user provides "<valid planet name>" for planet name
		When The user clicks the Submit Planet button
		Then The "<valid planet name>" planet should be added to the planetarium

		Examples:
			| valid planet name |
			| Neptune           |