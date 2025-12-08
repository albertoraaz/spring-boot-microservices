# Naming Server (Eureka Service Discovery)

This project serves as the **Service Discovery** component for the microservices architecture, implemented using **Spring Cloud Netflix Eureka**. It acts as a central registry where microservices register themselves and discover other registered services, enabling client-side load balancing and decoupling service providers from consumers.

## 🚀 Technologies & Stack

- **Java SDK**: Version 25
- **Framework**: Spring Boot (Spring MVC)
- **Service Discovery**: Spring Cloud Netflix Eureka Server
- **Build Tool**: Maven
- **Standard**: Jakarta EE

## 📋 Prerequisites

Before running the application, ensure you have the following installed:

- **Java Development Kit (JDK) 25**
- **Maven** (or use the provided `mvnw` wrapper)

## ⚙️ Configuration

The application is configured to run as a standalone Eureka Server. Key configurations in `src/main/resources/application.properties`:

| Property | Value | Description |
| :--- | :--- | :--- |
| `spring.application.name` | `naming-server` | Service identifier |
| `server.port` | `8761` | Standard Eureka port |
| `eureka.client.register-with-eureka` | `false` | Prevents server from registering with itself |
| `eureka.client.fetch-registry` | `false` | Prevents server from fetching registry info |

## 🛠️ Build and Run

### Using Maven Wrapper (Recommended)

1.  **Clean and Build**:
    ```bash
    ./mvnw clean package
    ```

2.  **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

### Using Local Maven

