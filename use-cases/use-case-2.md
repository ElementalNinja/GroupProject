# USE CASE: 2 Produce a report on the salary of employees in a department 

## CHARACTERISTIC INFORMATION

### Goal in Context

As an HR advisor I want to produce a report on the salary of employees in a department so that I can support financial reporting of the organisation.

### Scope

Company.

### Level

Primary task.

### Preconditions

The department is known, Database contains current employee salary data and all employee records of the department.

### Success End Condition

A report is available for HR to support finance.

### Failed End Condition

No report is produced.

### Primary Actor

HR Advisor.

### Trigger

A request for finance information is sent to HR.

## MAIN SUCCESS SCENARIO

1. Finance request salary information for a given role.
2. HR advisor captures name of the role to get salary information for.
3. HR advisor extracts current salary information of all employees of the given role.
4. HR advisor provides report to finance.

## EXTENSIONS

3. **Department cannot be found**:
    1. HR advisor informs finance the department doesnt exist or cannot be found.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
