# Performing Post Operation for positive scenario
# Getting complete URL from config.properties and constant class
@post
Feature: Validate post api 

@DummyTC03 @Positive
Scenario Outline: Check if user is able to submit POST service

Given perform post operation
When execute the post api with body "<name>" and "<job>"
Then should see expected result "<job>"

Examples:

|  name | job       |
| surbhi | employee | 
| chirag | colleague |


