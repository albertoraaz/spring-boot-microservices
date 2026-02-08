# 🌐 Enterprise Currency Microservices Ecosystem

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.x-blue)](https://spring.io/projects/spring-cloud)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)

A production-ready distributed system built with **Spring Boot 3.x** and **Spring Cloud**. This project demonstrates a cloud-native architecture for currency valuation and conversion, focusing on high availability, externalized configuration, and automated service discovery.

---

## 🏛️ System Architecture

The architecture follows a decentralized model where cross-cutting concerns (discovery, config, routing) are decoupled from the core business logic.


### Infrastructure Layer
* **[Naming Server (Eureka)](./naming-server)**: Implements **Service Discovery**. It acts as a central registry where microservices register themselves, enabling dynamic routing without hardcoded IPs.
* **[API Gateway](./api-gateway)**: Powered by **Spring Cloud Gateway**. Provides a unified entry point, handling request routing and security perimeters.
* **[Config Server](./spring-cloud-config-server)**: Centralized management for environment-specific properties (Dev, QA, Prod), ensuring a **Single Source of Truth** for configuration.

### Domain Layer (Business Logic)
* **[Currency Exchange Service](./currency-exchange-microservice)**: The core data provider for currency rates.
* **[Currency Conversion Service](./currency-conversion-service)**: An orchestrator service that consumes the Exchange service via **Declarative Feign Clients** to perform real-time calculations.

---

## 🛡️ Resilience & Fault Tolerance

In a senior-level architecture, the system is designed to fail gracefully. This ecosystem implements:

* **Load Balancing**: Integrated with **Spring Cloud LoadBalancer** for intelligent traffic distribution across service instances.
* **Circuit Breaker Pattern**: Powered by **Resilience4j**, preventing cascading failures when a downstream service becomes unresponsive.
* **Declarative REST Clients**: Using **OpenFeign** to abstract inter-service communication, reducing boilerplate and improving testability.


---

## 🚀 Getting Started

### Prerequisites
* **Java 17+** (LTS)
* **Maven 3.8+**
* **Docker & Docker Compose**

### The "Critical Path" Startup Sequence
In distributed systems, startup order matters. Launch the services in this specific sequence:

1.  **Config Server** (Port `8888`): Must be ready to provide configuration.
2.  **Naming Server** (Port `8761`): Must be up so subsequent services can register.
3.  **Domain Microservices** (Ports `8000`, `8100`): Business logic initialization.
4.  **API Gateway** (Port `8765`): Enable external traffic flow.

### Rapid Deployment with Docker
```bash
# Compile and build JARs
mvn clean package -DskipTests

# Spin up the entire ecosystem
docker-compose up -d


## 📊 Observability & Monitoring

This project is instrumented for production-grade monitoring:

Distributed Tracing: Uses Micrometer Tracing and Zipkin to visualize request spans across multiple service boundaries.

Health & Metrics: Spring Boot Actuator exposes vital health checks and performance metrics, ready for Prometheus/Grafana integration.

## 🔌 API Verification (Example Endpoints)

Service	                      Gateway Route (Port 8765)	                                 Description
Exchange	                  /currency-exchange/from/USD/to/INR	                     Fetch exchange rate
Conversion	                  /currency-conversion/from/USD/to/INR/quantity/10	         Convert currency amount
Discovery	                  http://localhost:8761	                                     Eureka Dashboard UI


👤 Author
Alberto Raaz
February, 2026.