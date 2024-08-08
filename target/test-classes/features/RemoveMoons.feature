@RemoveMoons
Feature: RemoveMoons

	@REV-TC-35 @JREQ-REV-55
	Scenario Outline: Positive Scenario Authorized user
	given a valid moon name, a user should be able to remove a moon from the Planetarium associated with planet they added
		Given The user logged in
		When The user should pick moon from dropdown
		When The user enters "<Valid Moonname>"
		Then The moon should be removed

	Examples: 
		| Valid Moonname |
		| Luna           |

	@REV-TC-36 @JREQ-REV-80 @JREQ-REV-57
	Scenario Outline: Negative Scenario Unauthorized user : Error Guessing test
	given an unauthorized user, attempting to remove a moon should fail
		Given The user is logged in wrong account
		When The user should pick moon from dropdown
		When The user enters "<Unauthorised Moonname>"
		Then The moon should not be removed

	Examples: 
		| Unauthorised Moonname |
		| Titan                 |

	@REV-TC-37 @JREQ-REV-58
	Scenario Outline: Negative Scenario Removing non-existent moon
	given a non-existent moon, attempting to remove it should fail
		Given The user logged in
		When The user should pick moon from dropdown
		When The user enters "<Invalid Moonname>"
		Then The moon should not be removed

	Examples: 
		| Invalid Moonname |
		| Phobos           |