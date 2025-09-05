# Copilot Instructions for Spring PetClinic

## Repository Overview

The Spring PetClinic is a canonical Spring Boot sample application demonstrating Spring Framework best practices. It's a veterinary clinic management system built with Spring Boot 3.5.0, Java 17, and supports both Maven and Gradle build systems.

**Key Technologies:**
- **Framework:** Spring Boot 3.5.0 with Spring Data JPA, Spring MVC, Thymeleaf templating
- **Java Version:** Java 17 (minimum requirement)
- **Build Systems:** Maven (primary) and Gradle (secondary) - dual build support
- **Database:** H2 (default in-memory), MySQL, PostgreSQL (with profiles)
- **Testing:** JUnit 5, Testcontainers, Spring Boot Test
- **Frontend:** Thymeleaf templates, Bootstrap 5.3.6, FontAwesome

## Build and Development Commands

### Prerequisites
- Java 17+ (JDK, not just JRE)
- System Maven 3.9.11+ (Maven wrapper `.mvn/` directory is missing in this repository)
- Git

### Maven Commands (Primary Build System)
**Always use system Maven (`mvn`) - the Maven wrapper is not properly configured.**

```bash
# Clean build
mvn clean package

# Run tests (takes ~1-2 minutes)
mvn test

# Run application
mvn spring-boot:run

# Build with CSS compilation (REQUIRED for UI changes)
mvn clean package -P css

# Skip tests during build
mvn clean package -DskipTests

# Run specific test
mvn test -Dtest=ClassName

# Validate code format and checkstyle
mvn validate
```

### Gradle Commands (Secondary Build System)
```bash
# Clean build
./gradlew clean build

# Run tests (takes ~45-60 seconds)
./gradlew test

# Run application
./gradlew bootRun

# Skip tests during build
./gradlew build -x test

# Check format and lint
./gradlew check
```

### Database Profiles
```bash
# MySQL (requires Docker or local MySQL)
mvn spring-boot:run -Dspring-boot.run.profiles=mysql

# PostgreSQL (requires Docker or local PostgreSQL)
mvn spring-boot:run -Dspring-boot.run.profiles=postgres

# Use docker-compose for databases
docker compose up mysql    # or postgres
```

## Code Quality and Formatting

### Automatic Code Formatting
The project uses Spring Java Format plugin for consistent code style:

```bash
# Validate formatting (Maven)
mvn spring-javaformat:validate

# Apply formatting (Maven)
mvn spring-javaformat:apply

# Checkstyle validation
mvn checkstyle:check
```

### Code Quality Tools
- **Spring Java Format:** Enforced during validate phase
- **Checkstyle:** Validates code style and HTTP(S) usage (nohttp checks)
- **JaCoCo:** Test coverage reporting
- **Enforcer Plugin:** Validates Java version requirements

## Project Structure

### Key Directories
```
src/main/java/org/springframework/samples/petclinic/
├── PetClinicApplication.java          # Main application class
├── model/                             # Domain entities (Pet, Owner, Vet, Visit)
├── owner/                             # Owner and Pet controllers/services
├── vet/                              # Veterinarian controllers/services  
└── system/                           # System configuration (caching, etc.)

src/main/resources/
├── application.properties             # Main configuration
├── application-mysql.properties      # MySQL profile config
├── application-postgres.properties   # PostgreSQL profile config
├── templates/                        # Thymeleaf HTML templates
├── static/resources/css/             # CSS files (generated from SCSS)
├── db/                               # Database schema and data
└── messages/                         # Internationalization files

src/test/java/                        # Test classes including integration tests
src/checkstyle/                       # Checkstyle configuration files
```

### Important Configuration Files
- `pom.xml` / `build.gradle` - Build configurations
- `docker-compose.yml` - Database containers
- `src/checkstyle/nohttp-checkstyle.xml` - Code style rules

## Testing

### Test Categories
- **Unit Tests:** Fast tests for individual components
- **Integration Tests:** 
  - `PetClinicIntegrationTests` - Full application with H2
  - `MySqlIntegrationTests` - With MySQL via Testcontainers  
  - `PostgresIntegrationTests` - With PostgreSQL via Docker Compose
- **Web Layer Tests:** Spring MVC slice tests for controllers

### Running Tests
```bash
# All tests (Maven: ~1-2 min, Gradle: ~45-60 sec)
mvn test
./gradlew test

# Fast tests only (skip integration)
mvn test -Dtest='!*IntegrationTests'

# Specific test class
mvn test -Dtest=OwnerControllerTests
```

## Development Workflow

### Making Changes
1. **Always run existing tests first** to understand current state
2. **For UI changes:** Use CSS profile: `mvn package -P css`
3. **For database changes:** Test with all supported databases
4. **Before committing:** Run `mvn validate` for code style checks

### CSS Development
CSS files are generated from SCSS sources:
```bash
# Compile SCSS to CSS (required for UI changes)
mvn package -P css

# Source SCSS files
src/main/scss/petclinic.scss

# Generated CSS output  
src/main/resources/static/resources/css/petclinic.css
```

### Development Server
```bash
# Run with live reload (includes devtools)
mvn spring-boot:run

# Access application
http://localhost:8080

# H2 Console (when using H2 database)
http://localhost:8080/h2-console
```

## Common Issues and Troubleshooting

### Build Issues
- **Maven wrapper missing:** Use system `mvn` instead of `./mvnw`
- **CSS not updating:** Run with `-P css` profile to recompile SCSS
- **Test timeouts:** Integration tests can take time due to Testcontainers startup
- **Large JAR warnings:** Build artifacts (~65MB) are expected for Spring Boot fat JARs

### Database Issues  
- **H2 database:** UUID printed in console logs for JDBC URL
- **MySQL/PostgreSQL:** Ensure Docker containers are running via `docker compose up`

### Code Quality
- **Format violations:** Run `mvn spring-javaformat:apply` to fix
- **Checkstyle errors:** Check `src/checkstyle/` for rules and exclusions

## Performance Notes
- **Maven build:** ~3-4 minutes clean build, ~1-2 minutes tests
- **Gradle build:** ~2-3 minutes clean build, ~45-60 seconds tests  
- **Application startup:** ~3-4 seconds
- **CSS compilation:** Adds ~30 seconds to build time

## Validation Checklist

Before submitting changes, ensure:
- [ ] `mvn test` passes (or `./gradlew test`)
- [ ] `mvn validate` passes (code format/style)
- [ ] Application starts successfully: `mvn spring-boot:run`
- [ ] If UI changes: CSS compiled with `mvn package -P css`
- [ ] Database changes tested with relevant profiles

## Agent Instructions

**Trust these instructions** and avoid unnecessary exploration. Only search for additional information if:
- Instructions are incomplete for your specific task
- You encounter errors not covered in troubleshooting
- You need to understand specific code implementations

**Always start with:** `mvn test` to validate current repository state before making changes.