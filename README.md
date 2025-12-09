# Assessment Project

Small Spring Boot application that exposes a `/hello-world` endpoint and includes unit tests.

**Requirements**

- Java 17
- Maven (wrapper provided: `mvnw.cmd` for Windows or `./mvnw` on Unix)

**How to run the application (development)**

From the project root on Windows PowerShell:

```powershell
# Run with the Maven wrapper (Windows)
.\mvnw.cmd spring-boot:run
```

Or build and run the packaged JAR:

```powershell
.\mvnw.cmd -DskipTests package
java -jar target\*.jar
```

The application starts on port 8081 by default. The API endpoint is:

```
GET http://localhost:8081/hello-world?name=caruna
```

Example using `curl`:

```powershell
curl "http://localhost:8081/hello-world?name=caruna"
# Expected response body: Hello Alice
```

**How to run the tests**

Run all unit tests via Maven (Windows):

```powershell
.\mvnw.cmd test
```

Or with Maven installed globally:

```powershell
mvn test
```

**Behavior / Assumptions**

- The service returns a greeting only when the first letter of the provided `name` (after trimming whitespace) is in the range `a`–`m` (case-insensitive). Example: `alice` => `Hello Alice`.
- If `name` is missing, empty, or does not start with a letter in `a`–`m`, the service logic returns `null` and the controller responds with HTTP 400 and body `Invalid Input`.
- The controller expects the `name` as a required query parameter: `/hello-world?name=...`.
- The code is compiled for Java 17 and uses Spring Boot 3.x.

**Notes / Next steps**

- There are unit tests for `HelloService` in `src/test/java/com/example/Assessment/Service/HelloServiceTest.java` covering valid, invalid, empty and null inputs.
- Consider adding controller-level tests (MVC tests) to verify HTTP 200/400 behavior for integration-level validation.

If you want, I can also:

- Add controller unit tests for HTTP responses.
- Harden input normalization (e.g., remove/handle non-letter leading chars).
- Update README with example responses and sample requests in PowerShell `Invoke-RestMethod` format.
