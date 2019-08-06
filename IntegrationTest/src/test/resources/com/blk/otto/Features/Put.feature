# Performing Put Operation for positive scenario
# Getting complete URL from config.properties and constant class
@put
Feature: Validate put api 

@DummyPUTTC05
Scenario Outline: Check if user is able to submit PUT service and verify response status code

Given I want to perform PUT operation
When I submit PUT request with body "<name>" and "<salary>"
Then I validate status code is "200"

Examples:

|  name | salary |
| test1 | 11232   |