# LOGGING ERROR AND WARNING MESSAGES USING SLF4J

In this project, I implemented **SLF4J logging** with **Logback** to demonstrate logging of error and warning messages.

---

## CREATING NEW PROJECT

I created a new Maven project using the VS Code command palette:

```
Maven: Create Maven Project
```


---

## ADDING DEPENDENCY

I added the following dependencies for **SLF4J API** and **Logback** in the `pom.xml` file:

```xml
<dependencies>
    <!-- SLF4J API -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.30</version>
    </dependency>

    <!-- Logback (SLF4J Implementation) -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>
</dependencies>
```

---

## FUNCTION CLASS

This class contains the main logic to demonstrate SLF4J logging.

### `LoggingExample.java`

```java
package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
```

---

## CONFIGURATION FILE

The Logback configuration file defines the pattern and destination for log messages.

### `logback.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="debug">
        <appender-ref ref="CONSOLE" />
    </root>

</configuration>
```
---

## OUTPUT

```bash
14:32:10.120 [main] ERROR com.example.LoggingExample - This is an error message
14:32:10.121 [main] WARN  com.example.LoggingExample - This is a warning message
```

This confirms that both error and warning logs were successfully generated.

