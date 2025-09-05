# Copilot Instructions for Spring PetClinic

## Repository Overview

Spring PetClinic is a **sample Spring Boot web application** that demonstrates modern Java web development patterns. It's a veterinary clinic management system that allows users to manage pet owners, pets, veterinarians, and visits.

**Key Technologies:**
- **Language:** Java 17+ (required)
- **Framework:** Spring Boot 3.5.0 with Spring MVC, Spring Data JPA, Thymeleaf
- **Database:** H2 (default), MySQL, PostgreSQL support
- **Build Tools:** Maven 3.6+ AND Gradle 8.14.3 (dual build system)
- **Frontend:** Thymeleaf templates, Bootstrap 5.3.6, SCSS
- **Testing:** JUnit 5, Testcontainers, Spring Boot Test
- **Code Quality:** Checkstyle, Spring Java Format, JaCoCo coverage

**Repository Size:** ~50MB codebase with ~60 Java classes in 4 main packages (owner, vet, system, model).

## Critical Build Instructions

### Prerequisites
- **Java 17+** (verified with OpenJDK 17.0.16) - **REQUIRED**
- Docker (for integration tests with Testcontainers)
- Maven 3.6+ OR Gradle 8.14.3

### Build Commands

**IMPORTANT:** Maven wrapper is broken (missing .mvn directory). Use system Maven or Gradle.

#### Working Build Commands:
```bash
# Gradle (RECOMMENDED - always works)
./gradlew clean build        # Full build with tests (~1min)
./gradlew clean build -x test   # Build without tests (~45s)
./gradlew test               # Run tests only (~1min)

# Maven (using system mvn)
mvn clean package           # Full build with tests (~4min)
mvn clean package -DskipTests  # Build without tests (~3min)
mvn test                    # Run tests only (~2min)
```

#### CSS Compilation (when modifying SCSS):
```bash
# Maven ONLY (Gradle doesn't support CSS compilation)
mvn package -P css -DskipTests   # Compiles SCSS to CSS (~30s)
```

#### Database Profiles:
```bash
# Run with different databases
./gradlew bootRun -Dspring.profiles.active=mysql
./gradlew bootRun -Dspring.profiles.active=postgres

# Start database containers
docker compose up mysql     # MySQL on port 3306
docker compose up postgres  # PostgreSQL on port 5432
```

### Validation Pipeline

**ALWAYS run these checks before committing:**

1. **Code Formatting:** `./gradlew checkstyleMain formatMain` (auto-fixes formatting)
2. **Code Quality:** `./gradlew checkstyleMain checkstyleTest` (Spring Java Format + NoHTTP)
3. **Tests:** `./gradlew test` (58 tests including integration tests)
4. **Build:** `./gradlew build` (includes all above + packaging)

**Build Timing:**
- Gradle full build: ~2.5 minutes
- Maven full build: ~4 minutes
- Tests only: ~1 minute
- Docker integration tests: +30s (MySQL/PostgreSQL containers)

### Common Build Issues & Solutions

**Issue:** `./mvnw: cannot open ./.mvn/wrapper/maven-wrapper.properties`
**Solution:** Use system Maven (`mvn`) or Gradle (`./gradlew`)

**Issue:** CSS not updated after SCSS changes
**Solution:** Run `mvn package -P css -DskipTests` (Maven only feature)

**Issue:** Integration tests fail with Docker errors
**Solution:** Ensure Docker is running: `docker ps` should work

**Issue:** Checkstyle violations
**Solution:** Run `./gradlew formatMain formatTest` to auto-fix formatting

## Project Architecture & Layout

### Source Structure
```
src/main/java/org/springframework/samples/petclinic/
├── PetClinicApplication.java          # Main Spring Boot class
├── model/                             # Core domain entities
├── owner/                             # Owner & Pet management
├── vet/                              # Veterinarian management  
├── system/                           # System utilities & config
└── service/                          # Business logic layer

src/main/resources/
├── application.properties            # Main configuration
├── application-mysql.properties      # MySQL profile config
├── application-postgres.properties   # PostgreSQL profile config
├── db/                              # Database scripts (H2, MySQL, PostgreSQL)
├── static/resources/css/            # Generated CSS files
├── templates/                       # Thymeleaf templates
└── messages/                        # i18n message bundles

src/main/scss/                       # SCSS source files
├── petclinic.scss                   # Main SCSS file
├── header.scss                      # Header styles  
├── responsive.scss                  # Responsive design
└── typography.scss                  # Typography styles

src/test/java/                       # Test classes
└── src/checkstyle/                  # Checkstyle configuration
```

### Key Configuration Files
- `pom.xml` - Maven build configuration
- `build.gradle` - Gradle build configuration  
- `docker-compose.yml` - Database containers
- `src/checkstyle/nohttp-checkstyle.xml` - Code quality rules
- `.editorconfig` - Editor configuration

### Main Application Entry Points
- **Main Class:** `org.springframework.samples.petclinic.PetClinicApplication`
- **Web Interface:** http://localhost:8080 (default H2 database)
- **H2 Console:** http://localhost:8080/h2-console (dev only)
- **Actuator:** http://localhost:8080/actuator (monitoring endpoints)

### Test Applications for Development
```bash
# Run these main() methods in your IDE for fast development:
org.springframework.samples.petclinic.PetClinicIntegrationTests  # H2 + DevTools
org.springframework.samples.petclinic.MySqlTestApplication       # MySQL + Testcontainers
org.springframework.samples.petclinic.PostgresIntegrationTests  # PostgreSQL + Docker Compose
```

## Dependencies & Frameworks

**Core Spring Dependencies:**
- spring-boot-starter-web (REST/MVC)
- spring-boot-starter-data-jpa (Database access)
- spring-boot-starter-thymeleaf (Templates)
- spring-boot-starter-validation (Bean validation)
- spring-boot-starter-cache (Caffeine caching)
- spring-boot-starter-actuator (Monitoring)

**Database Drivers:**
- H2 (in-memory, default)
- MySQL Connector/J 
- PostgreSQL Driver

**Frontend Assets:**
- Bootstrap 5.3.6 (via WebJars)
- Font Awesome 4.7.0 (via WebJars)
- WebJars Locator (automatic versioning)

**Testing:**
- spring-boot-starter-test (JUnit 5, MockMvc)
- spring-boot-testcontainers (Container testing)
- Testcontainers MySQL module

## Quick Start Commands

```bash
# Clone and build
git clone <repo-url>
cd spring-petclinic

# Quick build and run (uses H2 database)
./gradlew bootRun
# Open http://localhost:8080

# Run tests
./gradlew test

# Build for production
./gradlew clean build

# Run with MySQL (requires Docker)
docker compose up mysql -d
./gradlew bootRun -Dspring.profiles.active=mysql
```

## Agent Instructions

**Trust these instructions** - they have been validated by running all commands and processes. Only search for additional information if:
1. These instructions are incomplete for your specific task
2. You encounter errors not covered here
3. The repository structure has changed significantly

**For maximum efficiency:**
- Use Gradle over Maven (faster, more reliable)
- Always clean before production builds: `./gradlew clean build`
- Run `./gradlew formatMain` before committing to avoid formatting issues
- Use the test applications for rapid development iteration
- Remember that CSS compilation requires Maven with `-P css` profile

**Common patterns in this codebase:**
- Controllers follow Spring MVC conventions with `@Controller` and `@RequestMapping`
- Entities use JPA with `@Entity` and validation annotations  
- Repository layer uses Spring Data JPA with `@Repository`
- Thymeleaf templates in `src/main/resources/templates/`
- Static assets served from `src/main/resources/static/`