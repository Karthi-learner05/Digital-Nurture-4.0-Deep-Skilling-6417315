# MOCKING AND STUBBING

In this project, I implemented the use of **`Mockito`** to perform **mocking** and **stubbing** operations to test a service class (`MyService`) that depends on an external API class (`ExternalApi`). This helped in testing without relying on actual API calls, improving test speed and isolation.

---

## CREATING NEW PROJECT

I have used the VS Code command palette and selected the option:

```
Maven: Create new Project
```

This created a new **Maven JUnit project** where I added my test classes and dependencies.

---

## ADDING DEPENDENCY

I have added the dependency for **Mockito** and **JUnit 5** in the `pom.xml` file to allow mocking and assertion features.

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

These are the classes I wrote to simulate real-world service interaction with an external API.

### `ExternalApi.java`

```java
public class ExternalApi {
    public String getData() {
        // In real use, this might call a REST API
        return "Real Data from API";
    }
}
```

### `MyService.java`

```java
public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
```

---

## TEST CLASS

Here I tested `MyService` using **Mockito** to mock the `ExternalApi` class. I stubbed the `getData()` method to return fake data so that I can validate `MyService` logic independently.

### `MyServiceTest.java`

```java
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        System.out.println("Returned: " + result);
        assertEquals("Mock Data", result);
    }
}
```

---

## MOCKING AND STUBBING EXPLAINED

### 🔧 Mocking

Mocking means creating a fake version of a class (`ExternalApi`) so that its methods can be simulated.

```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);
```

### 🔁 Stubbing

Stubbing means telling a mock object *what to return* when a method is called.

```java
when(mockApi.getData()).thenReturn("Mock Data");
```

---

## TESTING

I tested this using the following command:

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
