# VERIFYING INTERACTIONS

In this project, I implemented **Mockito interaction verification** to confirm that specific methods are called as expected during service execution. This helps ensure the internal logic of the service is working correctly without relying on actual implementations.

---

## CREATING NEW PROJECT

I created a new Maven project using the VS Code command palette:

```
Maven: Create new Project
```

This provided a basic structure to add my source, test classes, and dependencies.

---

## ADDING DEPENDENCY

I added dependencies for **JUnit 5** and **Mockito** in the `pom.xml` file to support unit testing and mocking functionality.

```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.12.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## FUNCTION CLASSES

These classes are used to simulate an external API and a service class that uses it.

### `ExternalApi.java`

```java
package com.example;

public class ExternalApi {
    public String getData() {
        return "Real API data";
    }
}
```

### `MyService.java`

```java
package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void fetchData() {
        api.getData();
    }
}
```

---

## TEST CLASS

This test verifies that the `getData()` method in `ExternalApi` is called when `fetchData()` in `MyService` is executed.

### `MyServiceTest.java`

```java
package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
    }
}
```

---

## INTERACTION VERIFICATION

### 🔍 What is it?

Interaction verification checks whether a method was called on a mock object — and optionally how many times or with what arguments.

### ✅ In this project

```java
verify(mockApi).getData();
```

This ensures `getData()` was called once. If it wasn’t, the test will fail.

---

## TESTING

I ran the test using:

```bash
mvn test
```

✅ Output:

```bash
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
```

---

This verifies the behavior of the service through interaction-based unit testing, making the logic more robust and testable.
