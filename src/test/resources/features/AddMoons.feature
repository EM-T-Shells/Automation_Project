@AddMoons
Feature: AddMoons

	@REV-TC-28 @JREQ-REV-46
	Scenario Outline: Positive Scenario User can add moon
	given a valid moon name and planet, a user should be able to add a new moon to the Planetarium
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Valid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Valid MoonImage>"
		When The user clicks submit button
		Then The new moon should be added

	Examples: 
		| Valid Moonname | Valid PlanetId | Valid MoonImage |
		| Sagan's Moon   | 1              | moon-1.jpg      |

	@REV-TC-29 @JREQ-REV-51
	Scenario Outline: Boundary Analysis Moon name length 30 characters
	given a moon name with exactly 30 characters, a user should be able to add a new moon
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Valid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Valid MoonImage>"
		When The user clicks submit button
		Then The new moon should be added

	Examples: 
		| Valid Moonname                  | Valid PlanetId | Valid MoonImage |
		| MoonWithExactlyThirtyCharacter  | 1              | moon-1.jpg      |

	@REV-TC-30 @JREQ-REV-79 @JREQ-REV-52
	Scenario Outline: Positive Scenario User can add moon without image : Error Guess Testing
	given a moon name without an image user should still be able to add to database
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Valid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Invalid MoonImage>"
		When The user clicks submit button
		Then The new moon should be added

	Examples: 
		| Valid Moonname | Valid PlanetId | Invalid MoonImage |
		| Sagan's Moon   | 1              |                   |

	@REV-TC-31 @JREQ-REV-47
	Scenario Outline: Negative Scenario Moon name too long
	given a moon name longer than 30 characters, a user should not be able to add a new moon
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Invalid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Valid MoonImage>"
		When The user clicks submit button
		Then The new moon should not be added

	Examples: 
		| Invalid Moonname                | Valid PlanetId | Valid MoonImage |
		| MoonNameIsThirtyOneCharactersLg | 1              | moon-1.jpg      |

	@REV-TC-32 @JREQ-REV-48
	Scenario Outline: Negative Scenario Moon name not unique
	given a non-unique moon name, a user should not be able to add a new moon
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Invalid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Valid MoonImage>"
		When The user clicks submit button
		Then The new moon should not be added

	Examples: 
		| Invalid Moonname | Valid PlanetId | Valid MoonImage |
		| Luna             | 1              | moon-1.jpg      |

	@REV-TC-33 @JREQ-REV-49
	Scenario Outline: Negative Scenario Empty moon name
	given an empty moon name, a user should not be able to add a new moon
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Invalid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Valid MoonImage>"
		When The user clicks submit button
		Then The new moon should not be added

	Examples: 
		| Invalid Moonname | Valid PlanetId | Valid MoonImage |
		|                  | 1              | moon-1.jpg      |

	@REV-TC-34 @JREQ-REV-78 @JREQ-REV-50
	Scenario Outline: Negative Scenario Invalid image format
	given a valid moon name and an invalid image format, a user should not be able to add a new moon
		Given The user is logged in
		When The user should pick moon option from dropdown
		When The user enters a "<Valid Moonname>"
		When The user enters Id "<Valid PlanetId>"
		When The user provides a "<Invalid MoonImage>"
		When The user clicks submit button
		Then The new moon should not be added

	Examples: 
		| Valid Moonname | Valid PlanetId | Invalid MoonImage |
		| Sagan's Moon   | 1              | luna.txt          |