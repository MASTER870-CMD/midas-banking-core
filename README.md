# Midas
Project repo for the JPMC Advanced Software Engineering Forage program

# Midas Core | Financial Transaction Engine

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green.svg)](https://spring.io/projects/spring-boot)
[![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-Streaming-black.svg)](https://kafka.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## 📋 Executive Summary
**Midas Core** is a high-performance backend microservice designed to process real-time financial transactions. Developed as part of the **J.P. Morgan Chase & Co. Software Engineering Experience**, this system simulates a banking ledger that ingests high-volume data streams, validates transaction integrity against user balances, and persists records to a relational database.

This architecture ensures **zero data loss** through distributed messaging and maintains **ACID compliance** for all financial operations.

---

## 🏗️ System Architecture

**Data Flow:**
`Kafka Producer` → `Topic: trader-updates` → `Midas Core (Consumer)` → `Validation Logic` → `H2 Database`

### Key Technical Achievements
* **Asynchronous Messaging:** Integrated **Apache Kafka** to decouple transaction ingestion from processing, allowing the system to handle spikes in traffic without latency.
* **Incentive Integration:** Implemented a synchronous **REST API** client (`RestTemplate`) to interface with an external Incentive Engine, applying bonus logic to eligible transactions dynamically.
* **Data Persistence:** Modeled complex relationships using **JPA/Hibernate** entities (`UserRecord`, `TransactionRecord`) backed by an **H2 In-Memory Database** for rapid prototyping and testing.
* **API Exposure:** Developed a secure REST Endpoint (`GET /balance`) to expose real-time user financial data to frontend clients.

---

## 🛠️ Technology Stack

| Component | Technology | Role |
| :--- | :--- | :--- |
| **Core Framework** | Java 17, Spring Boot | Application logic and dependency injection |
| **Messaging** | Apache Kafka | Event streaming and transaction ingestion |
| **Database** | H2, Spring Data JPA | Relational data persistence and ORM |
| **Build Tool** | Maven | Dependency management and build automation |
| **Testing** | JUnit 5, EmbeddedKafka | Integration testing and system verification |

---

## 🚀 How to Run

### Prerequisites
* Java 17 SDK
* Apache Maven 3.8+
* Docker (optional, for standalone Kafka)

### Installation
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/MASTER870-CMD/midas-banking-core.git](https://github.com/MASTER870-CMD/midas-banking-core.git)
    cd midas-banking-core
    ```

2.  **Start the Service:**
    ```bash
    mvn spring-boot:run
    ```

3.  **Run Integration Tests:**
    ```bash
    mvn test
    ```

---

## 👨‍💻 Developer
**Shashank Gowda NB**
* *AI & Web Infrastructure Engineer*
* [Portfolio](https://shashankgowdanb.netlify.app/) | [LinkedIn](https://www.linkedin.com/in/shashank-gowda-nb-b94724375)

---
*Disclaimer: This project was developed for educational purposes as part of the Forage Job Simulation.*