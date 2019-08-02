# Performing delete Operation
# Getting complete URL from config.properties and constant class
@delete
Feature: Validate delete api 

@DummyTC04 
Scenario: Check if user is able to submit delete service

Given perform delete operation
When execute the delete api 
Then should see no response body
