# GolfTournament API

A simple REST API for managing golf club members and tournaments.  
Built with Spring Boot, and supports PostgreSQL (local or AWS RDS) or MySQL databases.

## Table of Contents

- [Running the Project in Docker](#running-the-project-in-docker)
- [Database Configuration](#database-configuration)
- [API Search Support](#api-search-support)
- [Endpoints Overview](#endpoints-overview)

## Running the Project in Docker

This project includes a `Dockerfile` and `docker-compose.yml` for easy setup.

### How to run:

1. **Build the application jar locally:**
   ```bash
   mvn clean package
   ```

2. **Build the Docker image:**
   ```bash
   docker build -t golfclub-api .
   ```

3. **Start the services using Docker Compose:**
   ```bash
   docker-compose up
   ```

This will start two containers:
- **Postgres database container** named `golfclub-db` with database `golfclub`
- **Spring Boot app container** named `golfclub-app`, running on port 8081 (mapped to container's 8080)

## Database Configuration

The database connection is configured in `src/main/resources/application.properties`.

There are three supported configurations:
- AWS RDS PostgreSQL (default, uncommented)
- Local PostgreSQL
- MySQL

### Example configuration from application.properties:

```properties
# PostgreSQL AWS RDS (default)
spring.datasource.url=jdbc:postgresql://database-1-instance-1.c4janj8wqbua.us-east-1.rds.amazonaws.com/golfclub
spring.datasource.username=postgres
spring.datasource.password=Fenthick

# Local PostgreSQL (uncomment to use)
# spring.datasource.url=jdbc:postgresql://localhost:5432/golfclub
# spring.datasource.username=postgres
# spring.datasource.password=Fenthick

# MySQL Setup (uncomment to use)
# spring.datasource.url=jdbc:mysql://localhost:3306/golfclub
# spring.datasource.username=root
# spring.datasource.password=your_password
# spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

**Important:** Make sure to update and uncomment the correct section based on the database you want to use.

### Docker Compose Database Configuration

The `docker-compose.yml` is currently set to use AWS RDS (`SPRING_DATASOURCE_URL` points to the RDS endpoint).

If you want to use the local Postgres container instead, update the environment variable in `docker-compose.yml`:

```yaml
environment:
  SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/golfclub
  SPRING_DATASOURCE_USERNAME: postgres
  SPRING_DATASOURCE_PASSWORD: Fenthick
```

## API Search Support

This API supports searching for Members and Tournaments with various filters.

### Members Search

| Filter Type | Endpoint | Example |
|-------------|----------|---------|
| By name | `GET /api/members/search/by-name?name=Jalen` | Search for members with name containing "Jalen" |
| By phone number | `GET /api/members/search/by-phone?phone=123` | Search for members with phone containing "123" |
| By membership duration | `GET /api/members/search/by-duration?duration=12` | Search by membership duration (months or years) |
| By tournament start date | `GET /api/members/search/by-tournament-start?startDate=2025-08-01` | Find members in tournaments starting on date |

**Note:** Date format is `YYYY-MM-DD`

### Tournaments Search

| Filter Type | Endpoint | Example |
|-------------|----------|---------|
| By start date | `GET /api/tournaments/search/by-start-date?startDate=2025-08-01` | Find tournaments starting on specific date |
| By location | `GET /api/tournaments/search/by-location?location=Vancouver` | Search tournaments by location (partial match) |
| Get tournament members | `GET /api/tournaments/{tournamentId}/members` | Get all members in a specific tournament |

## Endpoints Overview

### Members Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/members` | Get all members |
| `POST` | `/api/members` | Create a new member |
| `GET` | `/api/members/search/by-name` | Search members by name |
| `GET` | `/api/members/search/by-phone` | Search members by phone number |
| `GET` | `/api/members/search/by-duration` | Search members by membership duration |
| `GET` | `/api/members/search/by-tournament-start` | Search members by tournament start date |

### Tournaments Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/tournaments` | Get all tournaments |
| `POST` | `/api/tournaments` | Create a new tournament |
| `PUT` | `/api/tournaments/{tid}/add-member/{mid}` | Add member to a tournament |
| `GET` | `/api/tournaments/search/by-start-date` | Search tournaments by start date |
| `GET` | `/api/tournaments/search/by-location` | Search tournaments by location |
| `GET` | `/api/tournaments/{tid}/members` | Get members in a tournament |

Happy golfing! ⛳️🚀
