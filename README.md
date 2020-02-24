# Duke Project Template

This is a project template for a small CLI Java project. It uses Gradle for build automation and GitHub Actions for CI.

## Setting up in Intellij

Prerequisites: JDK 11

1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version
   1. Click `Configure` > `Project Defaults` > `Project Structure`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Click `Import Project`
1. Locate the `build.gradle` file in the project directory, select it, and click `OK`
1. If there are any further prompts, accept the defaults.
1. After the set up is complete, you can locate the `src/main/java/seedu/duke/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   > Task :compileJava
   > Task :processResources NO-SOURCE
   > Task :classes
   
   > Task :Duke.main()
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   
   What is your name?
   ```
   Type some word and press enter to let the execution proceed to the end. Also note how Intellij is now using Gradle to run your code (you can make Intellij run the code without Gradle [this way](tutorials/assets/RunUsingIntellij.png)).

## Build Automation using Gradle

This project is already configured to use Gradle. Read the following tutorial to learn how to use gradle to do tasks such as running tests, checking code against teh style rules, and generating the JAR file.
 
* [Gradle Tutorial](tutorials/gradleTutorial.md)

## Testing

To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)` script.

To run JUnit tests (after you have added JUnit tests), you can run the `test` Gradle task.

## CI using GitHub Actions

The project is already configured to use [GitHub actions](https://github.com/features/actions). When you push a commit to your fork or PR against an upstream repo, GitHub actions will run automatically to build and verify the product.