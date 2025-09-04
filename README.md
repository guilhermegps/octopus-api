# OCTOPUS-API

![Octopus-API Icon](https://github.com/guilhermegps/guilhermegps.github.io/blob/main/img/cthulhu.jpg)

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

OCTOPUS-API is an open-source Java-based backend framework built with Spring Boot, designed to serve as a robust foundation for developing scalable and modular backend applications. The project follows a multi-module architecture to promote low coupling, maintainability, and clear separation of concerns, leveraging Domain-Driven Design (DDD) principles and Spring Events for inter-module communication.

This project is ideal for developers looking to kickstart a new backend project with a pre-configured, production-ready structure, allowing them to focus on implementing business-specific logic without worrying about boilerplate setup.

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Modules](#modules)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- **Modular Architecture**: Organized into independent Maven modules for clear separation of concerns.
- **Spring Security with JWT**: Secure authentication and authorization using JSON Web Tokens (JWT).
- **Domain-Driven Design**: Structured around DDD principles to ensure a clean and maintainable codebase.
- **Event-Driven Communication**: Uses Spring Events to minimize coupling between modules.
- **Liquibase Integration**: Database schema management with Liquibase scripts.
- **Production-Ready**: Pre-configured with best practices for Spring Boot applications.

## Architecture
OCTOPUS-API adopts a multi-module Maven architecture to segregate responsibilities and reduce coupling. Each module represents a distinct bounded context, inspired by DDD principles. Modules communicate via Spring Events to ensure loose coupling and flexibility. The project is designed to be easily extensible, allowing developers to add new modules tailored to specific business needs.

## Modules
The project is currently divided into the following modules:

- **octopus-core**: Contains shared logic, utilities, and components used across all modules.
- **octopus-app**: The main application module, housing Spring Boot configurations, Liquibase scripts, and the entry point for the application.
- **octopus-auth**: Manages authentication and authorization using Spring Security and JJWT. Users authenticate via REST API with credentials and receive a temporary JWT for subsequent API calls.
- **octopus-personal**: Handles personal data management, including entities like persons, contacts, addresses, and companies.
- **octopus-test**: Just a module for tools to be used during unit testing.

## Technologies
The project uses the following technologies and versions:

| Technology       | Version         |
|------------------|-----------------|
| Java             | 21              |
| Spring Boot      | 3.4.4           |
| H2 Database      | 2.1.210         |
| MapStruct        | 1.5.5.Final     |
| JJWT             | 0.9.1           |
| Lombok           | 1.18.34         |

## Getting Started

### Prerequisites
To run or contribute to octopus, ensure you have the following installed:
- **Java 21** (JDK)
- **Maven** (for dependency management and building the project)
- A compatible IDE (e.g., Eclipse, VS Code, or IntelliJ IDEA)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/guilhermegps/octopus-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd octopus-api
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Running the Application
1. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
2. The application will start on `http://localhost:8080` (default port).
3. Access the API endpoints (e.g., authentication endpoint at `/api/auth/login`) using a tool like Postman or cURL.

Example authentication request:
```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"user","password":"pass"}'
```

## Contributing
We welcome contributions from the community! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit (`git commit -m "Add your feature"`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

Please ensure your code follows the project's coding standards and includes appropriate tests.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions, suggestions, or issues, please open an issue on the GitHub repository or contact the maintainers through their official contact methods.

---

Thank you for using OCTOPUS-API! We hope it accelerates your backend development journey.
