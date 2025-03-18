# Ejercicio

Ejercicio is a Spring Boot application that provides a REST API for managing products. It uses H2 as the database and Flyway for database migrations.

## Project Structure

```
.gitattributes
.gitignore
Ejercicio.postman_collection.json
HELP.md
mvnw
mvnw.cmd
pom.xml
.mvn/
.vscode/
src/
    main/
        java/
            com/
                paygoal/
                    ejercicio/
                        controllers/
                        dtos/
                        exceptions/
                        models/
                        repositories/
                        services/
        resources/
            application.properties
            db/
                migration/
test/
    java/
        com/
            paygoal/
                ejercicio/
target/
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Running the Application

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd ejercicio
    ```

2. Build the project:
    ```sh
    ./mvnw clean install
    ```

3. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

The application will start on `http://localhost:8080`.

### API Endpoints

The following endpoints are available:

- `GET /api/products` - Retrieves all products ordered by price
- `GET /api/products/{id}` - Retrieves a product by ID
- `GET /api/products?name={name}` - Retrieves a product by name
- `POST /api/products` - Creates a new product
- `PUT /api/products/{id}` - Updates an existing product
- `DELETE /api/products/{id}` - Deletes a product

Moreover, you can access the Swagger documentation by running the application and opening: `http://localhost:8080/swagger-ui/index.html`
### Database

The application uses an in-memory H2 database. The database schema is managed by Flyway. The initial schema is defined in `src/main/resources/db/migration/V1__create_products_table.sql`.

### Running Tests
**Tests were not implemented for this excercise**
To run the tests, use the following command:
```sh
./mvnw test
```

### Postman Collection

A Postman collection is provided in the file `Ejercicio.postman_collection.json` to test the API endpoints.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.