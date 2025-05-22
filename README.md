# Labseq Service

A Quarkus REST service that calculates values from the labseq sequence with caching for performance optimization.

## Sequence Definition

The labseq sequence l(n) is defined as:
- n=0 => l(0) = 0
- n=1 => l(1) = 1
- n=2 => l(2) = 0
- n=3 => l(3) = 1
- n>3 => l(n) = l(n-4) + l(n-3)

First values: 0, 1, 0, 1, 1, 1, 1, 2, 2, 2, 3, ...

## Execution Instructions

### Option 1: Local Development Mode

1. **Clone and navigate to project directory:**
```bash
git clone https://github.com/BrunoCastro13/Exercicio-Altice-Labs
```

2. **Run in development mode:**
```bash
./mvnw compile quarkus:dev
```

3. **Access the application:**
- Web GUI: http://localhost:8080


### Option 3: Docker Container

1. **Build the application:**
```bash
./mvnw package
```

2. **Build Docker image:**
```bash
docker build -f Dockerfile -t altice-labs .
```

3. **Run container:**
```bash
docker run -i --rm -p 8080:8080 altice-labs
```

## API Documentation

### Endpoint: GET /labseq/{n}

**Description:** Returns the value at position n in the labseq sequence

**Parameters:**
- `n` (path parameter): Non-negative integer representing the sequence index

**Responses:**
- `200 OK`: Success
  ```json
  {"result": 0}
  ```
- `400 Bad Request`: Invalid input (negative number)
  ```json
  {"error": "Index must be non-negative"}
  ```
- `500 Internal Server Error`: Calculation error
  ```json
  {"error": "Calculation error"}
  ```

**Examples:**
```bash
GET /labseq/0  -> {"result": 0}
GET /labseq/1  -> {"result": 1}
GET /labseq/4  -> {"result": 1}
GET /labseq/10 -> {"result": 3}
```
## Swagger/OpenAPI

Full API documentation is available at:
- Swagger UI: http://localhost:8080/swagger-ui
- OpenAPI JSON: http://localhost:8080/openapi