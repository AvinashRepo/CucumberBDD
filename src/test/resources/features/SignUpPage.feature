Feature: SignUpPageFeatureUI

Scenario: Sign up page 
Given User navigates to Conduit application
When User Creates random User Profiles in sign up screen
And User Navigates to Settings screen
Then User sets the user profile image url
Then user Validates profile image url in home page