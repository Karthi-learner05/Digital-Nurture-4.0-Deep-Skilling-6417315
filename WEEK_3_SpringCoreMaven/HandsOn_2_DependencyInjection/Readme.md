## 🔍 Exercise 2: Spring Dependency Injection using XML

In this project, I implemented a basic Library Management System using **Spring Core**. The application demonstrates **Setter-based Dependency Injection** using **XML configuration**. The `BookService` depends on a `BookRepository`, and Spring handles the injection using the `applicationContext.xml` file.

---

###  Maven Dependency
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.9</version>
    </dependency>
</dependencies>
```

---

###  `pom.xml`
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.kutty</groupId>
    <artifactId>LibrarySpringDI</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.9</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.kutty.librarydi.LibraryApp</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

###  Repository Creation

 `BookRepository.java`
```java
package com.kutty.librarydi.repository;

public class BookRepository {
    public String getBook() {
        return "The Spring in Action";
    }
}
```

---

###  Service Creation

 `BookService.java`
```java
package com.kutty.librarydi.service;

import com.kutty.librarydi.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Book Name: " + bookRepository.getBook());
    }
}
```

---

###  Main Program

 `LibraryApp.java`
```java
package com.kutty.librarydi;

import com.kutty.librarydi.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.displayBook();
    }
}
```

---

###  Application Context Configuration

📄 `applicationContext.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
          http://www.springframework.org/schema/beans 
          http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bookRepository" class="com.kutty.librarydi.repository.BookRepository" />

    <bean id="bookService" class="com.kutty.librarydi.service.BookService">
        <property name="bookRepository" ref="bookRepository" />
    </bean>

</beans>
```

---

### ✅ Output
```
[DI Success] BookRepository injected into BookService
[BookService] Book Name: Spring Boot in Action

```

