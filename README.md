# Secret Santa Assignment Program

## Overview
This program assigns Secret Santa pairs among employees while following rules:
- No one gifts themselves.
- No repetition of last year's pairing.

## How to run
1. Place your input files in `resources/`
2. Place with naming conventions and extensions which is of test data
3. Build with Maven and confirm all unit tests are passing:
    ```bash
    mvn clean install
    ```
4. Run the file [run_secret_santa.bat](run_secret_santa.bat)
5. Confirm the results in the resources folder

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
