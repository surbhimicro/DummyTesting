# Performing Get Operation
# Getting URL from constant class
@get
Feature: Testing get API
  
@DummyTC01 @Positive
Scenario: Validate get API with given url

Given want to perform get operation
When execute get api
Then should see the circuitId "1" 