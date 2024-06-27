# Selenium Test Automation Framework using Spring

## Description

This project is a Selenium framework built using Spring Boot. It integrates various libraries and tools to facilitate automated testing and browser interaction.

## Main Technologies Used

- **Spring Framework**:
  - Spring Boot
  - Spring AOP
  - Spring Data JPA

- **Database**:
  - H2 Database (In-memory database)

- **Testing and Automation**:
  - Selenium
  - WebDriverManager
  - TestNG
  - Cucumber

- **Utility Libraries**:
  - JavaFaker
  - SnakeYAML
  - Lombok

### Build and Dependency Management
- **Gradle**: Used as the build automation tool.
- **Spring Boot**: Provides a framework to build and run the application.
- **Spring Dependency Management Plugin**: Manages dependencies in a Spring Boot project.

### Java Version
- **Java 17**: The project is compatible with Java 17.

### Core Libraries
- **Spring Boot Starters**:
    - `spring-boot-starter`: Core starter, including auto-configuration support, logging, and YAML.
    - `spring-boot-starter-aop`: Starter for aspect-oriented programming with Spring AOP and AspectJ.
    - `spring-boot-starter-data-jpa`: Starter for using Spring Data JPA with Hibernate.

### Database
- **H2 Database**: An in-memory database used for runtime.

### Testing and Automation
- **Selenium**: Used for browser automation.
- **WebDriverManager**: Manages browser drivers automatically.
- **TestNG**: Testing framework inspired by JUnit, with advanced features.
- **Cucumber**: Supports behavior-driven development (BDD) with Gherkin syntax.

### Utility Libraries
- **JavaFaker**: Generates fake data for testing purposes.
- **SnakeYAML**: YAML parser and emitter for Java.
- **Lombok**: Reduces boilerplate code with annotations like `@Getter`, `@Setter`, etc.

### Dependency Versions
- Selenium: `4.22.0`
- WebDriverManager: `5.9.1`
- TestNG: `7.9.0`
- Cucumber: `7.14.0`
- JavaFaker: `1.0.2`
- SnakeYAML: `2.2`
- Lombok: `1.18.22`

### Testing Configuration
- **TestNG Integration**: Configured to run with a suite specified in `src/test/resources/testng.xml`.
- **Parallel Execution**: Tests are executed in parallel with a thread count of 2.

## Build and Run

To build and run the project, use the following Gradle commands:

```sh
./gradlew build
