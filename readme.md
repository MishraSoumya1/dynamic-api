# 📦 Dynamic JSON API with Schema Validation – Spring Boot

This Spring Boot project dynamically validates JSON requests using JSON Schema based on the event type. It includes OpenAPI documentation, H2 in-memory database, and is structured for extension with rate limiting, auditing, and exception handling.

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven 3.8+
- Git (optional)

---

## 🛠️ Build and Run

### 1. 📥 Clone the Repository

```bash
git clone https://github.com/your-org/dynamic-api.git
cd dynamic-api
```

### 2. 🔨 Build the Project

```bash
mvn clean install
```

This command will:
- Download dependencies
- Compile the code
- Run tests
- Package the app into a JAR file

### 3. ▶️ Run the Application

Using Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

Or run the packaged JAR directly:

```bash
java -jar target/dynamic-api-0.0.1-SNAPSHOT.jar
```

---

## 🌐 API Usage

### Example Endpoint

```
POST http://localhost:8080/events/userCreated
```

### Sample Payload

```json
{
  "event_type": "user_signup",
  "data": {
    "email": "jane.doe@example.com",
    "name": "Jane Doe"
  }
}
```

### Schema Location

Put JSON Schema files in:

```
src/main/resources/schemas/
```

Example: `user_signup_schema.json`

---

## 📚 Swagger / OpenAPI Docs

```
http://localhost:8080/swagger-ui.html
```

---

## 🗄️ H2 In-Memory Database

### Console Access (Browser)

```
http://localhost:8080/h2-console
```

### JDBC URL

Use the following in the H2 login page:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

### Enable Console (application.properties)

Make sure your `application.properties` contains:

```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

You can use this DB to log or persist events post-validation.

---

## 🧰 Tech Stack

- Spring Boot 3.5.x
- JSON Schema Validator (`com.networknt`)
- Jackson
- OpenAPI via `springdoc-openapi`
- H2 in-memory DB
- Maven for build

---

## 📄 License

This project is open for educational and demo purposes.
