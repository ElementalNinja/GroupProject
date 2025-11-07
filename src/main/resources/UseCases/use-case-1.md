# USE CASE 1: All the countries in the world organised by largest population to smallest. 

## CHARACTERISTIC INFORMATION

### Goal in Context
To allow a user/employee to retrieve a list of all countries organised from largest to smallest

### Scope

Company.

### Level
Primary Task


### Preconditions
Database must contain all countries with accurate populations


### Success End Condition
List is displayed correctly with accurate populations and in correct order


### Failed End Condition
List is displayed in the wrong order
List doesnt display


### Primary Actor

User/Employee

### Trigger

User / Employee requested to see a list of all countries in the world with their populations from largest to smallest

## MAIN SUCCESS SCENARIO

List is displayed successfully in the correct order

## EXTENSIONS
1. List is displayed in the wrong order
    i. Edit the "ORDER BY" part of the query
2.  List isnt displayed at all
    i. Evaluate query then check database to see if problem lies there


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
