# BMBank API
BMBank API is a REST API that handles simple financial transactions. Specifically, this app supports the creation/deletion of new/existing bank users, retrieving user information, and making withdraws and deposits.

## Motivation
This application is an attempt to demonstrate knowledge on REST API design using Java and Spring Boot. Specifically, this app will contain best practices for project structure, style, unit tests, exceptions, logging, and microservice design.

## Installation
BMBank API can only be run locally via Java.

### Requirements
This application requires:
- JDK 16
- MySQL

### Database
In the current state, this app can only connect to a MySQL database that is pre-existing. You must create a database before running the app with the following specifications:
- Database name: Bank

#### Environment Variables
There are environment variables that are included to be able to change the configuration of the app. How to use these environment variables will be described in the next section. The given environment variables are the following:
- **MYSQL_HOST**: Defaults to `localhost`
- **MYSQL_DBNAME**: Defaults to `Bank`
- **MYSQL_USERNAME**: Defaults to `user`
- **MYSQL_PASSWORD**: Defaults to `password`

### Running Locally Via the Command Line
Run the app by running the below command from the root application directory:
```
./mvnw spring-boot:run
```
Note that you should include environment variable as described above when running this app. For example, if your MySQL Database is named BMBANK, you would run the following:
```
./mvnw spring-boot:run -MYSQL_DBNAME=BMBANK
```

### Architecture
This is a diagram to display a high-level overview of the system's architecture:
![System Architecture](src\main\java\com\bm\bank\assets\HighLevelDiagram.png)
</br>
The system is broken down into 3 main services: Deposit, Withdrawal, and User. Each service takes in requests from a client, interacts with the database to modify the content, and returns a response back to the client.

This is a diagram to display how the API is designed:
![API Architecture](src\main\java\com\bm\bank\assets\APIDiagram.png)
Each service has the following capability:
- Deposit: Make a deposit of a given amount given the userId.
- Withdrawal: Make a withdrawal of a given amount given the userId.
- User: handles creating a new user, finding an existing user, or deleting an existing user from the system.

### Error Hierarchy
This is a diagram to display the hierarchy of exceptions that may be thrown:
![Error Hierarchy](src\main\java\com\bm\bank\assets\ExceptionDiagram.png)

### Status Codes
This application comes with custom exceptions. The table below will provide context into the exceptions and the status codes that they are mapped to.

| Status Code       | Exception Type               | Description                                        |
| :---------------- | :--------------------------: | :------------------------------------------------: | 
| 0                 | OK                           | Successful                                         |
| 1000              | UserIDNotProvidedException   | No Id was provided                                 |
| 1001              | UserNotFoundException        | No User was found with given info                  |
| 1002              | UserNotProvidedException     | Provided User details were not provided            |
| 1002              | UserNotProvidedException     | Provided User details were not provided            |
| 2000              | NegativeDepositException     | Attempted to make a deposit with negative value    |
| 3000              | NegativeWithdrawalException  | Attempted to make a withdrawal with negative value |
| 3001              | ExcessiveWithdrawalException | Attempted to withdraw more than given user has     |
| 5000              | InvalidTypeException         | Request parameter contains invalid type            |

#### VS Code Run/Debug Configuration
Below is a sample debug settings.json configuration if VS Code IDE is used to run the application:
```
{
    "java.configuration.updateBuildConfiguration": "automatic"
}
```
Below is a sample debug launch.json configuration if VS Code IDE is used to run the application:
```
{
    "configurations:": [{
        "type":"java",
        "name":"Spring Boot",
        "request":"launch",
        "mainClass":"com.bm.bank.BMBankApplication",
        "env":{}
    }]
}
```

[More Info On VSCode Debugging](https://code.visualstudio.com/docs/editor/debugging)

## Usage
Use cURL or Postman (or equivalent) to interact with the application.
The Swagger URL is defined as: http://localhost:8080/swagger-ui/