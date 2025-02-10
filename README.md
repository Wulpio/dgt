# Fee Calculation Service

This is a Spring Boot-based fee calculation service that provides a flexible architecture for implementing different fee calculation algorithms. The project is structured into multiple modules to support extensibility and maintainability.

## Project Structure

The project consists of the following modules:

- **[gateway](gateway):** Defines the interface for fee calculation algorithms, serving as a contract for implementations.
- **[basicDbFee](basicDbFee):** Implements the database layer and provides an algorithm that fetches fee data from a database.
- **[constantFee](constantFee):** An example of an alternative algorithm that can be easily integrated into the system.
- **[core](core):** A REST module that exposes endpoints to trigger fee calculations.

## Features

- Modular design for easy extension of new fee calculation algorithms.
- Spring Boot framework for rapid development and deployment.
- REST API for seamless integration with other applications.
- RabbitMQ for triggering calculations.
- Database-backed fee calculation implementation.
- Example constant fee calculation algorithm.

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java 21+
- Maven 3+
- Docker
- A relational database (if using the `basicDbFee` module)

### Building the Project

To build the project, run:
```sh
mvn clean install
```

### Running the Application

You can start the service using:
```sh
mvn spring-boot:run -pl core -Dspring.profiles.active=postgres
```
or with H2 database:
```sh
mvn spring-boot:run -pl core
```

### Swagger
http://localhost:8080/swagger-ui/index.html

### API Endpoints

| Method | Endpoint         | Description                         |
|--------|----------------|-------------------------------------|
| GET    | `/api/compute`   | Triggers the fee calculation process |

### RabbitMQ
```sh
docker pull rabbitmq:3-management
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
queue name: 'QUEUE_DEMO_02'

## Extending the Project

To add a new fee calculation algorithm:
1. Implement the `gateway` interface in a new module.
2. Register the implementation as a Spring bean.
3. The `core` module need minor change for detection of the new algorithm

## Todos
- api documentation + examples in swagger
- embed postgres into test container + adjust rabbitMQ test container integration with github workflow (@ItIsWorkingOnMyMachine)
