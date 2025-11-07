# USE CASE 4:  The top N populated countries in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context
To allow a user to enter a number then the first ___ countries with the largest population is displayed

### Scope

Company.

### Level
Primary Task


### Preconditions
Database Contains all country names, regions and populations


### Success End Condition
List is successfully displayed to the user with accurate population and the correct amount of countries being displayed.


### Failed End Condition
Wrong amount of countries displayed
Wrong countries Displayed



### Primary Actor

User

### Trigger

User wishes to find out the top ___ most populated countries in the world

## MAIN SUCCESS SCENARIO

The list with the correct amount of countries in the correct order is displayed to the user

## EXTENSIONS

1. Wrong amount of countries displayed
    i. Query needs to be evaluated again to find out why the number entered by the user isnt working
2. Wrong countries displayed
    i. Query needs to be evaluated again to find out whats wrong
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
