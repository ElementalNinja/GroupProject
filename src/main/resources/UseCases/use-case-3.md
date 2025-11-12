# USE CASE 3: All the countries in a region organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context
To allow employees to retrieve countries in a certain region based on population (largest to smallest)

### Scope

Company.

### Level

Primary Task

### Preconditions
Database contains all countries within regions
Database contains all populations for the countries within a region


### Success End Condition

List of all countries in a region displayed from largest to smallest is shown to the employee

### Failed End Condition
List was unable to be generated due to invalid data
Not all countries within a region were displayed
List was displayed in wrong order


### Primary Actor
Employee


### Trigger
Organisation requests employee to get a list of all countries within a region ordered from largest to smallest


## MAIN SUCCESS SCENARIO
List is displayed successfully with all countries in the region and in correct order


## EXTENSIONS

1. Countries are missing from the database
    i. Database must be updated with new data
2. Population data is incorrect
    i. Database must be updated with correct populations
3. List is displayed in wrong order
    i. Query must be evaluated again to figure out the problem

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
