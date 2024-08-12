@0Registration
Feature: 0Registration

	@REV-TC-2 @JREQ-REV-3
	Scenario Outline: Positive Scenario user registration
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a valid username "<Valid Username>"
		When The user provides a valid password "<valid password>"
		When The user clicks the Create button
		When The user is alerted that Account created successfully with username "<Valid Username>" and password "<valid password>"
		When The user clicks OK to dismiss the alert
		Then The user is redirected to the login page

		Examples:
			| Valid Username | valid password |
			| CarlSagan      | Cosmos@2024    |

	@REV-TC-3 @JREQ-REV-5
	Scenario Outline: Negative Scenario Username not unique
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a non-unique username "<Non-unique username>"
		When The user provides a valid password "<valid password>"
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "<Non-unique username>" and password "<valid password>"

		Examples:
			| valid password | Non-unique username |
			| Cosmos@2024    | Batman              |

	@REV-TC-4 @JREQ-REV-6
	Scenario Outline: Negative scenario username too long
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a too long username "<Too long username>"
		When The user provides a valid password "<valid password>"
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "<Too long username>" and password "<valid password>"

		Examples:
			| Too long username                        | valid password |
			| CarlSagan_with_a_really_really_long_name | Cosmos@2024    |

	@REV-TC-7 @JREQ-REV-9
	Scenario Outline: Negative scenario empty username
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides an empty username
		When The user provides a valid password "<valid password>"
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "" and password "<valid password>"

		Examples:
			| valid password |
			| Cosmos@2024    |

	@REV-TC-8 @JREQ-REV-10
	Scenario Outline: Negative scenario empty password
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a valid username "<Valid Username>"
		When The user provides an empty password
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "<Valid Username>" and password ""

		Examples:
			| Valid Username |
			| CarlSagan      |

	@REV-TC-39 @JREQ-REV-12
	Scenario Outline: Positive Scenario user registration Password length exactly 30 characters
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a valid username "<Valid Username>"
		When The user provides a password that is exactly thirty characters "<Password exactly 30 characters>"
		When The user clicks the Create button
		Then The user is alerted that Account created successfully with username "<Valid Username>" and password "<Password exactly 30 characters>"
		When The user clicks OK to dismiss the alert
		Then The user is redirected to the login page

		Examples:
			| Valid Username | Password exactly 30 characters |
			| UniqueUsername | PasswordWithExactlyCharacters! |

	@REV-TC-42 @JREQ-REV-7
	Scenario Outline: Negative scenario password too long - new
	Password greater than 30 characters
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a valid username "<Valid Username>"
		When The user provides a too long password "<Invalid password>"
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "<Valid Username>" and password "<Invalid password>"

		Examples:
			| Valid Username | Invalid password                                   |
			| CarlSagan      | ThisIsAVeryLongPasswordThatExceedsThirtyCharacters |

	@REV-TC-43 @JREQ-REV-8
	Scenario Outline: Negative Scenario credentials too long - new
	Both username and password greater than 30 characters each
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a too long username "<Too long username>"
		When The user provides a too long password "<Too long password>"
		When The user clicks the Create button
		Then The user is alerted that Account creation failed with username "<Too long username>" and password "<Too long password>"

		Examples:
			| Too long username                        | Too long password                                  |
			| CarlSagan_with_a_really_really_long_name | ThisIsAVeryLongPasswordThatExceedsThirtyCharacters |

	@REV-TC-44 @JREQ-REV-11
	Scenario Outline: Positive Scenario user registration Username length exactly 30 characters - new
	Boundary Analysis Username length 30 characters
	Using a username with exactly 30 characters and valid password a user should be able to register an account
		Given The user navigates to the landing page
		When The user clicks Create Account link and is redirected to the registration page
		When The user provides a username that is exactly thirty characters "<Username 30 characters>"
		When The user provides a valid password "<valid password>"
		When The user clicks the Create button
		When The user is alerted that Account created successfully with username "<Username 30 characters>" and password "<valid password>"
		When The user clicks OK to dismiss the alert
		Then The user is redirected to the login page

		Examples:
			| Username 30 characters         | valid password |
			| UserWitExactlyThirtyCharacters | Cosmos@2024    |