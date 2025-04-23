# Secret Santa Assignment Program

## Overview
This program assigns Secret Santa pairs among employees while following rules:
- No one gifts themselves.
- No repetition of last year's pairing.

## How to run
1. Place your input files in `resources/`
2. Build with Maven:
    ```bash
    mvn clean install
    ```
3. Run the application:
    ```bash
    java -cp target/SecretSanta-1.0.jar Main
    ```

## Structure
- `model/` - Employee object
- `service/` - CSV reading and assignment logic
- `util/` - CSV writer
- `exception/` - Custom exceptions

## Requirements
- Java 8+
- Maven

---

Happy Secret Santa!
