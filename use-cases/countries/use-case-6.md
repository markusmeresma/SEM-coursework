# USE CASE: 6 Produce a Report on the top N populated countries in specific region where N is provided by the user.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an *user* I want *to produce the following report to be generated
on the top N populated countries in specific region where N is provided by the user* so that *I can report on population information*.

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current population data.

### Success End Condition

A report is available for the organisation to provide.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for population on the top N populated countries in specific region is sent to organisation.

## MAIN SUCCESS SCENARIO

1. The user requests population information about the top N populated countries in specific region where N is provided by the user.
2. The user gets the top N populated countries in specific region information.
3. The user takes out the information about the country population.
4. The user provides report about population information.

## EXTENSIONS

3. **Information about the country does not exist**:

   i.The user is unable to produce report on the country information.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5
