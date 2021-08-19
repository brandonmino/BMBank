# BMBank API
BMBank API handles simple financial transactions
## Motivation
This application is an attempt to demonstrate my knowledge on REST API design using Java and Spring Boot. Specifically, I am showing the best practices for project structure, style, unit tests, exceptions, logging, and microservice design.
## Installation
BMBank API can be run locally via Java, or it can be run in a container.
### Requirements
This application requires:
- JDK 16
- MySQL
- Dependencies listed in `requirements.txt` below
### Database
In the current state, this app can only connect to a MySql database that is pre-existing. You must create a database before running the app with the following specifications:
- Database name: bank
- Database tables: ClientInfo, DepositTransactions

You also must manually enter the database infomation to be able to properly connect. To do so, go to `applications.properties` and modify the following fields:
- spring.datasource.url
- spring.datasource.username
- spring.datasource.password
### Running Locally Via the Command Line
Run the app by running the below command from the root application directory:
```
./mvnw spring-boot:run
```
#### VS Code Run/Debug Configuration
Below is a sample debug configuration if VS Code IDE is used to run the application:
```
{
    "java.configuration.updateBuildConfiguration": "interactive"
}
```
[More Info On VSCode Debugging](https://code.visualstudio.com/docs/editor/debugging)

#### External Dependencies
Anywhere Bank has external dependencies that are needed to run.

## Usage
Use cURL or Postman (or equivalent) to interact with the application.