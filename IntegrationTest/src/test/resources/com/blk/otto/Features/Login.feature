Feature: Testing a REST API

@BDD
Scenario: Check if user is able to submit GET API request

   Given I want to query for get request
   Then Request data is return 

@Login
Scenario: Validate with non BDD style

Given perform get operation for "http://ergast.com/api/f1/2017/circuits.json"
Then should see the circuitId "albert_park" 

@NBDD
Scenario: Validate Post operation with non BDD style

Given perform post operation for "https://reqres.in/api/users" with body
 | name     | job    |
 | morpheus | leader |
Then should see the name "morpheus" 

   
@PBDD
Scenario Outline: Check if user is able to submit POST service

Given I want to execute service "<serviceName>"
Then I the POST request as per the data in Excel Worksheet "<EWorksheet>" with "<name>" and "<job>"

Examples:

| serviceName    | EWorksheet | name | job       |
| create         |  0        | surbhi | employee | 
| create         |  1        | chirag | colleague |

