# Renewable Energy Management System

A Spring Boot Microservices project that manages renewable energy generation from **Solar Panels**, **Wind Turbines**, and **Battery Storage**, and combines them through a **Distribution Service**.

---

## Project Overview

This project demonstrates a Microservices Architecture where different services work independently and communicate using REST APIs.

The system collects energy generation data from:

- Solar Energy
- Wind Energy
- Battery Storage

The Distribution Service gathers information from all services and calculates the final energy distribution.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- RestTemplate
- Maven
- IntelliJ IDEA
- Postman
- Git & GitHub

---

## Project Structure

```
Renewable-Energy-System
│
├── Solar Service
├── Wind Service
├── Battery Service
├── Distribution Service
└── API Gateway
```

---

## Microservices

### 1. Solar Service

Port: **8081**

Functions

- Add Solar Panel
- View All Solar Panels
- View Solar Panel by ID
- Delete Solar Panel

---

### 2. Wind Service

Port: **8082**

Functions

- Add Wind Turbine
- View All Wind Turbines
- View Wind Turbine by ID
- Delete Wind Turbine

---

### 3. Battery Service

Port: **8083**

Functions

- Add Battery
- View All Batteries
- View Battery by ID
- Delete Battery

---

### 4. Distribution Service

Port: **8084**

Functions

- Generate Final Energy Distribution
- View Distribution Records
- View Distribution Record by ID
- Delete Distribution Record

The Distribution Service communicates with

- Solar Service
- Wind Service
- Battery Service

using **RestTemplate**.

---

### 5. API Gateway

Port: **8080**

Acts as a single entry point for all microservices.

---

## REST APIs

### Solar Service

| Method | Endpoint |
|---------|----------|
| POST | /solar-panels |
| GET | /solar-panels |
| GET | /solar-panels/{id} |
| DELETE | /solar-panels/{id} |

---

### Wind Service

| Method | Endpoint |
|---------|----------|
| POST | /wind-turbines |
| GET | /wind-turbines |
| GET | /wind-turbines/{id} |
| DELETE | /wind-turbines/{id} |

---

### Battery Service

| Method | Endpoint |
|---------|----------|
| POST | /battery |
| GET | /battery |
| GET | /battery/{id} |
| DELETE | /battery/{id} |

---

### Distribution Service

| Method | Endpoint |
|---------|----------|
| POST | /distribution |
| GET | /distribution |
| GET | /distribution/{id} |
| GET | /distribution/generate |
| DELETE | /distribution/{id} |

---

## Database

Each service uses its own **H2 In-Memory Database**.

### H2 Console URLs

Solar

```
http://localhost:8081/h2-console
```

Wind

```
http://localhost:8082/h2-console
```

Battery

```
http://localhost:8083/h2-console
```

Distribution

```
http://localhost:8084/h2-console
```

---

## Application Ports

| Service | Port |
|----------|------|
| API Gateway | 8080 |
| Solar Service | 8081 |
| Wind Service | 8082 |
| Battery Service | 8083 |
| Distribution Service | 8084 |

---

## Project Workflow

```
Solar Service
       │
       ▼
Wind Service
       │
       ▼
Battery Service
       │
       ▼
Distribution Service
       │
       ▼
Final Energy Distribution
```

---

## Sample Final Output

```json
{
    "id": 1,
    "totalSolarGeneration": 420.0,
    "totalWindGeneration": 850.0,
    "totalGeneration": 1270.0,
    "batteryPercentage": 80.0,
    "energyDistributed": 1270.0,
    "status": "ENERGY DISTRIBUTED"
}
```

---

## How to Run

### Step 1

Clone the repository

```bash
git clone https://github.com/your-username/renewable-energy-system.git
```

### Step 2

Open all projects in IntelliJ IDEA.

### Step 3

Run the services in the following order:

1. Solar Service
2. Wind Service
3. Battery Service
4. Distribution Service
5. API Gateway

### Step 4

Test APIs using Postman or Chrome.

---

## Future Enhancements

- Service Discovery using Eureka
- Spring Cloud Gateway
- MySQL Database
- Docker Support
- JWT Authentication
- Monitoring with Spring Boot Actuator
- Kubernetes Deployment

---

## Author
212225040038

**Avinash Karthick B M**

BE Computer Science Engineering

Saveetha Engineering College

---

## License

This project is developed for educational and internship purposes.
