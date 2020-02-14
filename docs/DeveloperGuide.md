# Duke - Developer Guide

## Setting up

**Prerequisites**

* JDK 11
* Recommended: IntelliJ IDE
* Fork this repo to your GitHub account and clone the fork to your computer

**Importing the project into IntelliJ**

1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first).
1. Set up the correct JDK version.
   * Click `Configure` > `Structure for new Projects` (in older versions of Intellij:`Configure` > `Project Defaults` > `Project Structure`).
   * If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11.
   * Click `OK`.
1. Click `Import Project`.
1. Locate the project directory and click `OK`.
1. Select `Create project from existing sources` and click `Next`.
1. Rename the project if you want. Click `Next`.
1. Ensure that your src folder is checked. Keep clicking `Next`.
1. Click `Finish`.

## Design

### Architecture
This is an explanation of the high-level design of the application.
Given below is a quick overview of each component.

`UI` is responsible for showing the UI and handling user interactions.
* At app launch it renders the UI
* At shut down it tears down the UI

`Logic` is responsible for the business logic behind the application and consists of a few components.
* `Parser` - parses input from the user into `Command` objects.
* `Commands` - Represents a command from the user that can be executed.


### UI Component
*(insert UML diagram)*

The UI ... 

*(insert UML diagram)*

*(insert UML diagram)*

*(insert UML diagram)*


### Logic Component
### Model Component
### Storage Component

## Implementation
This section descibes some noteworthy details on how certain features are implemented.

### Date parsing feature

#### Chosen implementation
The date parsing feature uses the Stanford CoreNLP library for state-of-the-art intent detection.
It extends `DateParser` and parses input with the CoreNLP annotator to obtain a dependency parse.
Additionally, it implements the following operations:
* NlpDateParser#TextToDate() - Converts text to a `LocalDate`. 
* NlpDateParser#SetModel() - Sets the model the parser uses to perform POS tagging. 

Given below is an example usage scenario.
1. The user launches the application for the first time.
1. The user executes `todo n/test d/next week`.
The `CommandParser` delegates `next week` to `NlpDateParser#TextToDate`.
`NlpDateParser` requires the model from `NlpModelProvider`.
1. `NlpModelProvider` initializes and loads the model in from file. 
1. `NlpDateParser#TextToDate` returns a `LocalDate` object to `CommandParser`. 

The following sequence diagram shows how the parsing operation works.

*(insert UML diagram)*

#### Design considerations
#####Chosen implentation: Use machine learning to parse date.
**Pros:**
* Captures a wide array of possible formats.

**Cons:**
* Extremely long startup time as loading of model can take up to 3 minutes on a laptop.
* Model is 30 times the size of the application (300Mb).
* Low accuracy (2 out of 100 queries resulted in a correct date).

#####Considered implentation: Hard code fixed formats that the date can be in.
**Pros:**
* Easy to implement

**Cons:**
* Difficult to maintain as more formats are added.

## Product Scope
### Target user profile

## User Stories
|Priority| As a ... | I want to ... | So that I can ...|
|---|---|---|---|
|***|new user|see usage instructions|refer to them when I forget how to use the application|
|**|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Use Cases
For all use cases below, the **System** is `Duke` and the **Actor** is the `user` unless specified otherwise.

### Use Case: Add to-do
**MSS**
1. User adds to-do
1. Duke adds the to-do

Use case ends.

**Extension**
* 2a. The to-do is invalid
    * 2a1. Duke shows an error message
    
        Use case ends.
        
## Non-functional Requirements
1. Should work on any mainstream OS as long as it has Java 11 or above installed.


## Glossary
*glossary item* - Definition

## Product Survey

## Instructions for Manual Testing 
* Launch and shutdown
* Adding a to-do
