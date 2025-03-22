# TerneraShop back
Api for TerneraShop built with SpringBoot, connects to Postgres (on Supabase)

## Running

Runs with 
`"back\mvnw.cmd" spring-boot:run -f "back\pom.xml"`

In development uses `http://localhost:8080`

### Environments
There's 2 profiles: `dev` and `prod`. 
Both profiles are in [pom.xml](./pom.xml).
Variable `SPRING_PROFILES_ACTIVE` decides wich of them is loaded. If the variable doesn't exist `dev` profile will be loaded.

 1. `dev` (Development)

    Environments need to be located in `.env`
    ```properties
    spring.datasource.url=jdbc:postgresql://server:5432/postgres?user=postgres&password=###pw###
    
    ```
 
 2. `prod` (Production)

    These two variables are needed
    ```
    DB_URL=jdbc:postgresql://server:5432/postgres?user=postgres&password=###pw###
    SPRING_PROFILES_ACTIVE=prod
    ```

Common SpringBoot properties are in [src/main/resources/application.properties](./src/main/resources/application.properties) while each profile has its own properties to load environment specifics (like spring.database.url) 
- dev: [src/main/resources/application-dev.properties](./src/main/resources/application-dev.properties)

- prod: [src/main/resources/application-prod.properties](./src/main/resources/application-prod.properties)

## Data generation

Sql Tables generated with JPA are in [src/main/resources/db/migration/V1__CreateWithJpa.sql](./src/main/resources/db/migration/V1__CreateWithJpa.sql)

some products were loaded from [src/main/resources/data.sql](./src/main/resources/data.sql)
