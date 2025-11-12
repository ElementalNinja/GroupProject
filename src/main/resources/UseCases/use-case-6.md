# USE CASE 6: The top N populated countries in a region where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context
To allow users to enter a number then the top ___ most populated countries in a specific reason are displayed

### Scope

Company.

### Level

Primary Task

### Preconditions
Database must contain accurate countries, regions and populations


### Success End Condition
List is displayed successfully with the specified amount of countries displayed in the correct order from the specific reason


### Failed End Condition
Displayed wrong amount of countries
Displayed countries in the wrong order
Displayed countries from the wrong region


### Primary Actor

User

### Trigger
User wishes to see a specific number of the most populated countries within a specific reason


## MAIN SUCCESS SCENARIO

List is displayed successfully with the specified amount of countries displayed in the correct order from the specific reason

## EXTENSIONS
1. Wrong country region, wrong order, correct region wrong countries
    i. Look at the query code again to find the issues

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
