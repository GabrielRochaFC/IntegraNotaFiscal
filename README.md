# Integra Nota Fiscal

![License](https://img.shields.io/badge/license-MIT-green)
![Versão do Java](https://img.shields.io/badge/Java-21-blue)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

## Description

This project is a Jakarta EE application developed with Spring Data JPA for data persistence, Lombok to reduce
boilerplate code, and Spring MVC for creating RESTful APIs. It is configured to run with Java 21 on port 8083.
Essentially, this project aims to integrate with payment gateways to generate invoices in an easier and more efficient
way.

## Project Structure

- **Controller**: Contains the API endpoints.
- **Service**: Implements the business logic of the application.
- **Repository**: Interface for database communication.
- **Model**: Contains the database entities.

## Requirements

- Java 21
- Maven 3.6+
- MySql Database

## Installation

1. Clone the repository:

    ```sh
    git clone https://github.com/GabrielRochaFC/MentoriaRasmoo-IntegraNotaFiscal.git
    ```

2. Navigate to the project directory:

    ```sh
    cd IntegraNf
    ```

3. Compile the project using Maven:

    ```sh
    mvn clean install
    ```

4. Run the application:

    ```sh
    java -jar target/IntegraNf-0.0.1-SNAPSHOT.jar
    ```

## Configuration

Make sure to configure the database information in `src/main/resources/application.properties` as needed:

```properties
server.port=${SERVER_PORT}
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```

## Endpoints

The application provides various endpoints, detailed below. The context path is `/integranf`.

### Authentication

- **POST** `/auth/login`: User authentication.
    - Request Body: `{"email": "user@example.com", "password": "password"}`
    - Response: `{"token": "jwt_token"}`

- **POST** `/auth/register`: Register new users.
    - Request Body: `{"email": "user@example.com", "password": "password", ...}`
    - Response: `{"id": 1, "email": "user@example.com", ...}`

### Users

- **GET** `/user`: Lists all paginated users.
    - Query Params: `page`, `size`
    - Response: `[{"id": 1, "name": "John Doe", ...}, ...]`

- **PATCH** `/user/{id}`: Updates user information.
    - Path Param: `id` (User ID)
    - Request Body: `{"name": "New Name", ...}`
    - Response: `{"id": 1, "name": "New Name", ...}`

### User Types

- **GET** `/user-type`: Lists all user types.
    - Response: `[{"id": 1, "type": "Admin", ...}, ...]`

### Subscription Types

- **POST** `/subscription-type`: Creates a new subscription type.
    - Request Body: `{"type": "Premium", "duration": 12, ...}`
    - Response: `{"id": 1, "type": "Premium", ...}`

- **GET** `/subscription-type`: Lists all paginated subscription types.
    - Query Params: `page`, `size`, `enabled`
    - Response: `[{"id": 1, "type": "Premium", ...}, ...]`

### Subscriptions

- **POST** `/subscriptions/select`: Assigns a subscription to an authenticated user.
    - Request Body: `{"subscriptionTypeId": 1, ...}`
    - Response: `{"id": 1, "userId": 1, "subscriptionTypeId": 1, ...}`

### Gateways

- **POST** `/gateway`: Creates a new gateway.
    - Request Body: `{"name": "Gateway1", ...}`
    - Response: `{"id": 1, "name": "Gateway1", ...}`

- **GET** `/gateway`: Lists all gateways.
    - Response: `[{"id": 1, "name": "Gateway1", ...}, ...]`

- **POST** `/gateway/integrations`: Registers a user integration with a gateway.
    - Request Body: `{"userId": 1, "gatewayId": 1, ...}`
    - Response: `{"id": 1, "userId": 1, "gatewayId": 1, ...}`

- **GET** `/gateway/integrations`: Lists all user integrations with gateways, paginated.
    - Query Params: `page`, `size`
    - Response: `[{"id": 1, "userId": 1, "gatewayId": 1, ...}, ...]`

## About the Project

This project was developed during the **Mentoria Start by Rasmoo**. Learn more at [Rasmoo]().

## Contribution

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

## Contact

- LinkedIn: [Gabriel Rocha](https://linkedin.com/in/gabriel-rocha-28ab8414b)

---

Made with ❤️ by [Gabriel Rocha](https://github.com/GabrielRochaFC)