# Customers-Bank-Details

This project is a Spring Boot CRUD application for managing a `Customers` Bank Details. It includes basic CRUD operations with Dto projections Service layers and Proper messages for All exceptions.

## Features

- Add new Customer
- Auto regestration of Maturity and Maturity Period Date
- List all Customers profiles
- Projection of All details When serched By account No
- Projection of limited account details when searched by name or id
- Validation of new Customers entry
- Account no unique and of Indian Banks Only
- Phone No Validation for unique and Indian Number Only
- exception's handlings: MethodArgumentNotValid ,ConstraintViolation ,DataIntegrityViolationException ,etc.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Gradle-Groovy
- Hibernate
- Swagger
- postgreSQL (can be replaced with any other database)
- Spring Validation

## Getting Started

### Prerequisites

- Java 8 or higher
- Gradle-Groovy 3.3.2 or higher

### Installation

1. Clone the repository:
   ```sh
   https://github.com/KoushalKumar22/Customers-Bank-Details.git
   cd Customers-Bank-Details
2. Build the project:
   ```sh
     ./gradlew clean build
3. Run the application:
   ```sh
     ./gradlew bootRun
The application will start on http://localhost:8080.

### Endpoints

1. Test Endpoint
- URL: `/test`

- Method: GET

- Description: Test the API to ensure it's running

- Response: "This Is A Test Run"

2. Save DATA
- URL: `/save`
- Method: POST
- Description: Save a new customer data record to the database
- Request Body: json in postman
  ```sh
  {
    "accNo": "98765432100",
    "fname": "Raja",
    "lname": "Kumar",
    "address": "Ranchi",
    "phone": "9876543120"
  }

3. Validation

- accNo: Must not be empty, should be of 9 to 12 digits long and should be unique.
- fname: Must not be empty, should not contain any special characters.
- lname: Must not be empty, should not contain any special characters.
- address: cannot be empty.
- phone no must start form no between 6 to 9(as per Indian Phone no) and must be of 10 digits and must be unique.

4. Get All Users
- URL: `/all`
- Method: GET
- Description: Returns a list of all Customers profiles.

5. Get Id ,First Name ,Last Name ,Phone Number of the Users
- URL: `/id/{id}`
- Method: GET
- Description: Returns the limited details of the Customers Bank Account.

6. Get Id ,First Name ,Last Name ,Phone Number of the Users
- URL: `/fname/{fname}`
- Method: GET
- Description: Returns the limited details of the Customers Bank Account.

7. Get Id ,Account Number ,First Name ,Last Name ,Address ,Phone Number ,Account Opeaning Date ,Maturity Compleation Date of the Users
- URL: `/accNo/{accNo}`
- Method: GET
- Description: Returns All Details related the Customers Bank Account.

### Exception Handling

The application includes a global exception handler that captures `Exceptions` and returns a meaningful error response.
- example error response
  ```sh
   {
  "accNo": "Account number already exists.",
  "accNo": "Please Enter The Bank Account No!",
  "accNo": "Please Enter An Valid Account Number!",
  "fname": "Please Provide First Name!",
  "fname": "Name should not contain special characters",
  "lname": "Please Provide Last Name!",
  "lname": "Name should not contain special characters",
  "phoneno": "Please Enter an Phone Number!",
  "phoneno": "Phone number already exists.",
  any Other error: "Database error occurred."
  }
### Project Structure
- `BankAccountApplication`: file containing Main class.
- `Customer`: Entity class representing a Customer profile.
- `CustomerDTO`: Dto layer for saving and projection.
- `SearchDTO`: For limited projection of Entity while Searching.
- `CustomerRepository`: Repository interface for CRUD operations on user profiles.
- `IdNotFoundException`: Exception handleing for no data found as per entered id.
- `NameNotFoundException`: Exception Handleing For no Data found as per provided First Name.
- `AccountNotFoundException`: Exception Handleing for no account found as per Account Number provided.
- `GlobalExceptionHandler`: Global exception handler for exception handling and proper errors messages.
- `CustomerConfiguration`: for adding Model mapper ConfiGuration.
- `Servicesinter`: For Declaration for custom methods for various purposeis.
- `CustomerServices`: Addition of service layer for more security.
- `CustomerController`: REST controller for handling Customer-related requests.

## Acknowledgements

I would like to thank the following resources and individuals who made this project possible:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate](http://hibernate.org/)
- [Spring Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation)
- [JetBrains](https://www.jetbrains.com/idea/)
- [Stack Overflow](https://stackoverflow.com/)
