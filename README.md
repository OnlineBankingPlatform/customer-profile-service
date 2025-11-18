# Customer Profile Service

A Spring Boot microservice for managing customer profile data within an Online Banking Platform.

## Technology Stack

- **Spring Boot**: 3.5.7
- **Java**: 21
- **Database**: PostgreSQL (Local), H2 (Testing)
- **Build Tool**: Maven

## Prerequisites

- Java 21
- Docker & Docker Compose
- Maven (or use included wrapper)

## Getting Started

### 1. Start the Database

```bash
docker-compose up -d
```

### 2. Build the Project

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8081**

## Configuration

### Default Database (Local)
- Host: localhost:5432
- Database: obp_customer_local
- Username: obp_local_user
- Password: obp_local_pass

### Running with Different Profiles

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## Project Structure

```
src/
├── main/
│   ├── java/com/evaitcs/obp/customerprofile/
│   │   ├── controller/     # REST endpoints
│   │   ├── service/        # Business logic
│   │   ├── repository/     # Data access
│   │   ├── entity/         # JPA entities
│   │   └── dto/            # Data transfer objects
│   └── resources/
│       ├── application.yml
│       └── db/migration/   # Flyway scripts
└── test/
```

## Key Dependencies

- Spring Boot Web
- Spring Data JPA
- Spring Security
- Spring Cloud OpenFeign
- Flyway Migration
- Lombok
- MapStruct

## Troubleshooting

If the application fails to start with a datasource error, ensure PostgreSQL is running:
```bash
docker-compose up -d
```

## License

(To be specified)
