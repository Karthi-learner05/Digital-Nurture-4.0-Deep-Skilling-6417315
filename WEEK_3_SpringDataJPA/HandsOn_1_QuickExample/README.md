# Spring Data JPA - Quick Example

A simple Spring Boot project demonstrating Spring Data JPA with MySQL integration to fetch country data from the database.

---

## Dependencies (`pom.xml`)

```xml
<dependencies>
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>

    <!-- Spring Boot Starter Web (Optional for testing) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

---

## Model Layer

### `Country.java`

```java
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // Getters, setters, toString()
}
```

---

## Repository Layer

### `CountryRepository.java`

```java
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
```

---

## Service Layer

### `CountryService.java`

```java
public interface CountryService {
    List<Country> getAllCountries();
}
```

### `CountryServiceImpl.java`

```java
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
```

---

## Main Application

### `OrmLearnApplication.java`

```java
@SpringBootApplication
public class OrmLearnApplication {
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(System.out::println);
    }
}
```

---

## `application.properties`

```properties
# Logging (minimized)
logging.level.root=ERROR
logging.level.com.cognizant=DEBUG

# DB config
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=Karthi123@

# Hibernate dialect and DDL mode
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## Final Output (Console)

``` bash
Country [code=AS, name=Australia]
Country [code=FR, name=France]
Country [code=IN, name=India]
Country [code=PR, name=Paris]
Country [code=US, name=United States of America]
04-07-25 11:56:10.478 licationShutdownHook  INFO rEntityManagerFactoryBean                   destroy  660 Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.613 s
[INFO] Finished at: 2025-07-04T11:56:11+05:30
[INFO] ------------------------------------------------------------------------
...
```
