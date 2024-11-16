# Kitten Adoption
## Overview
This REST API is designed to manage a kitten adoption platform, allowing shelters to manage kittens and adoption requests. Built with Spring Boot, it follows Domain-Driven Design principles and REST architecture best practices.

## Key Features
- Kitten Management (Add, Edit, List)
- Adoption Request Processing
- Adoption Status Tracking
- Shelter Management
- Applicant Information Management

## Project Structure
```
src/main/java/
├── config/          # Configuration classes
├── domain/         # Domain-specific packages
│   ├── kitten/    # Kitten domain
│   └── shelter/   # Shelter domain
├── controller/     # REST controllers
├── dto/           # Data Transfer Objects
├── exception/     # Custom exceptions and handlers
├── model/         # Entity classes
├── repository/    # Data access layer
├── request/       # Request models
├── response/      # Response models
└── service/       # Business logic layer
```

## API Endpoints

### 1. Kitten Management
```
POST /api/kitty/add
```
- Adds a new kitten to the system
- Required fields: name, breed, description, photo, age
```
PUT /api/kitty/edit/{id}
```
- Updates kitten information
- Required fields: name, breed, description, photo, age
```
GET /api/kittens
```
- Retrieves all available kittens
```
GET /api/kitty/info/{id}
```
- Retrieves detailed information about a specific kitten

### 2. Shelter Management
```
POST /api/shelter/add
```
- Processes new adoption requests
- Required fields: kittenId, applicant_name, phoneNumber, email, message, socialMediaUrl
```
GET /api/shelter
```
- Retrieves all pending adoptions
```
GET /api/shelter/info/{id}
```
- Retrieves specific adoption request information
```
POST /api/shelter/approved
```
- Approves an adoption request
- Required fields: adoptionId, kittenId

## Technical Stack
- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Java Version**: 17
- **Architecture**: REST API, Domain-Driven Design
- **Design Pattern**: MVC

## API Response Format
All endpoints return standardized responses with:
- Appropriate HTTP status code
- Response message
- Data payload when applicable

Example success response for adding a kitten:
```json
{
    "name": "Luna",
    "breed": "Siamese",
    "description": "Playful and friendly kitten",
    "photo": "luna.jpg",
    "age": 3
}
```

Example success response for adoption request:
```json
{
    "message": "kitty request added successfully"
}
```

## Error Handling
- 400 Bad Request: Invalid input data
- 404 Not Found: Resource not found
- 500 Internal Server Error: Server-side issues
- Standardized error responses

Example error response:
```json
{
    "timestamp": "2024-03-15T12:00:00Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid kitten data provided",
    "path": "/api/kitty/add"
}
```

## Setup Requirements
1. Java 17
2. Gradle
3. Database configuration
4. Spring Boot properties

## Installation & Running
```bash
# Clone the repository
git clone [repository-url]

# Navigate to project directory
cd kitten-adoption-api

# Build the project
gradle clean build

# Run the application
gradle bootRun
```

## Environment Variables
```
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
SERVER_PORT=your_server_port
```

## Build Configuration
```groovy
plugins {
    id 'org.springframework.boot' version '3.x.x'
    id 'io.spring.dependency-management'
    id 'java'
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    
    // Testing dependencies
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    
    // Add other dependencies as needed
}

tasks.named('test') {
    useJUnitPlatform()
}
```

## Example Requests

### Adding a New Kitten
```bash
curl -X POST http://localhost:8080/api/kitty/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Luna",
    "breed": "Siamese",
    "description": "Playful and friendly kitten",
    "photo": "luna.jpg",
    "age": 3
  }'
```

### Submitting an Adoption Request
```bash
curl -X POST http://localhost:8080/api/shelter/add \
  -H "Content-Type: application/json" \
  -d '{
    "kittenId": 1,
    "applicant_name": "John Doe",
    "phoneNumber": "1234567890",
    "email": "john@example.com",
    "message": "I would love to adopt Luna",
    "socialMediaUrl": "https://social.example.com/john"
  }'
```



## Acknowledgments
* Spring Boot team for the excellent framework
* All contributors who participate in this project
