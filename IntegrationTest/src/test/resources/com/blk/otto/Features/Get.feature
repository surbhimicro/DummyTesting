# Performing positive scenario for Get Operation
# Getting complete URL from config.properties and constant class
@get
Feature: Testing get API
  
@DummyTC01 @Positive
Scenario: Validate get API with given url

Given want to perform get operation
When execute get api
Then should see the circuitId "albert_park" 

#Performing the negative scenario for get call

@DummyTC02 @Negative
Scenario: Validate get API with invalid data

Given perform get operation
When execute get api with invalid data
Then should be invalid status