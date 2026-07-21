🌱 Renewable Energy Management System
A Microservices-based Renewable Energy Management System developed using Java 21, Spring Boot, Spring Data JPA, H2 Database, REST APIs, RestTemplate, and Spring Cloud API Gateway.

This application manages renewable energy sources such as Solar Panels, Wind Turbines, and Battery Storage, and intelligently distributes power based on energy demand.

📌 Project Overview
The Renewable Energy Management System simulates a real-world renewable energy platform where energy generated from multiple renewable sources is monitored, stored, and distributed efficiently.

The project follows a Microservices Architecture, where each service performs a specific responsibility and communicates with other services through REST APIs.

✨ Key Features
🌞 Manage Solar Panel information
🌬️ Monitor Wind Turbine energy generation
🔋 Track Battery storage information
⚡ Calculate and distribute power based on demand
🔄 Service-to-Service Communication using RestTemplate
🌐 Centralized API Routing using API Gateway
🏗️ System Architecture
                    Client
                      │
                      ▼
               API Gateway (8080)
                      │
      ┌───────────────┼────────────────┐
      │               │                │
      ▼               ▼                ▼
 Solar Service    Wind Service    Battery Service
   (8081)            (8082)           (8083)
      │               │                │
      └───────────────┼────────────────┘
                      ▼
          Distribution Service (8084)
🚀 Technologies Used
Technology	Version
Java	21
Spring Boot	3.x
Spring Web	Latest
Spring Data JPA	Latest
Spring Cloud Gateway	Latest
RestTemplate	Latest
H2 Database	Latest
Maven	3.x
IntelliJ IDEA	Latest
Postman	Latest
📂 Project Structure
Renewable-Energy-Management-System
│
├── api-gateway
├── solar-service
├── wind-service
├── battery-service
├── distribution-service
├── README.md
🔧 Microservices
🌞 Solar Service
Port: 8081

Responsibilities
Register Solar Panels
View Solar Panels
Update Solar Panel Details
Delete Solar Panels
Get Solar Panel by ID
🌬️ Wind Service
Port: 8082

Responsibilities
Register Wind Turbines
View Wind Turbines
Update Wind Turbine Details
Delete Wind Turbines
Get Wind Turbine by ID
🔋 Battery Service
Port: 8083

Responsibilities
Register Battery
View Battery Details
Update Battery Information
Delete Battery
Get Battery by ID
⚡ Distribution Service
Port: 8084

Responsibilities
Collect Solar Service data
Collect Wind Service data
Collect Battery Service data
Calculate Power Distribution
Store Distribution History
View Distribution Details
The Distribution Service communicates with the Solar, Wind, and Battery services using RestTemplate.

🌐 API Gateway
Port: 8080

Acts as the single entry point for all client requests and routes them to the appropriate microservice.

🗄️ H2 Database Console
Each microservice uses its own H2 In-Memory Database.

Service	Port	H2 Console
Solar Service	8081	http://localhost:8081/h2-console
Wind Service	8082	http://localhost:8082/h2-console
Battery Service	8083	http://localhost:8083/h2-console
Distribution Service	8084	http://localhost:8084/h2-console
Login Details
Driver Class

org.h2.Driver
JDBC URL
Service	JDBC URL
Solar	jdbc:h2:mem:solar_db
Wind	jdbc:h2:mem:wind_db
Battery	jdbc:h2:mem:battery_db
Distribution	jdbc:h2:mem:distribution_db
Username

sa
Password

Leave blank
📡 REST APIs
🌞 Solar Service
Method	Endpoint
POST	/solar-panels
GET	/solar-panels
GET	/solar-panels/{id}
PUT	/solar-panels/{id}
DELETE	/solar-panels/{id}
🌬️ Wind Service
Method	Endpoint
POST	/wind-turbines
GET	/wind-turbines
GET	/wind-turbines/{id}
PUT	/wind-turbines/{id}
DELETE	/wind-turbines/{id}
🔋 Battery Service
Method	Endpoint
POST	/battery
GET	/battery
GET	/battery/{id}
PUT	/battery/{id}
DELETE	/battery/{id}
⚡ Distribution Service
Method	Endpoint
POST	/distribution/balance?requiredPower=700
GET	/distribution
GET	/distribution/{id}
🔄 Service Communication
The Distribution Service communicates with:

Solar Service
Wind Service
Battery Service
using RestTemplate to retrieve renewable energy data and calculate the final power distribution.

✅ Features
Microservices Architecture
RESTful APIs
CRUD Operations
Layered Architecture
DTO Pattern
Spring Data JPA
H2 Database
REST API Communication
API Gateway Routing
Exception Handling
📮 API Testing
All APIs were tested using Postman.

Sample Request
POST http://localhost:8084/distribution/balance?requiredPower=700
Sample Response
{
  "id": 1,
  "requiredPower": 700,
  "solarPowerUsed": 400,
  "windPowerUsed": 200,
  "batteryPowerUsed": 100,
  "message": "Power Distributed Successfully"
}
▶️ Running the Project
Step 1
Clone the repository.

git clone https://github.com/your-username/Renewable-Energy-Management-System.git
Step 2
Open each microservice in IntelliJ IDEA.

Step 3
Run the services in the following order:

Solar Service (8081)
Wind Service (8082)
Battery Service (8083)
Distribution Service (8084)
API Gateway (8080)
Step 4
Access the H2 Console or test the APIs using Postman.

📈 Future Enhancements
Eureka Service Discovery
Spring Security with JWT Authentication
Docker Containerization
Kubernetes Deployment
Prometheus Monitoring
Grafana Dashboard
CI/CD using GitHub Actions
👨‍💻 Author
REF : 212225040038

Avinash Karthick B M

B.Tech – CSE

Saveetha Engineering College
