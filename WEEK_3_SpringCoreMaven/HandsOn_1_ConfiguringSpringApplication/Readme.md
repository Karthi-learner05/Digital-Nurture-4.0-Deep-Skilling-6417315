# SPRING CORE XML CONFIGURATION - LIBRARY MANAGEMENT APP

This project demonstrates a **basic Spring application** using **Spring Core XML configuration**. 
It defines beans and manages dependencies between a `BookService` and a `BookRepository` for a library management system.

---

## CREATING NEW PROJECT

I created a Maven project named **LibraryManagement** using the VS Code command palette:

```
Maven: Create Maven Project
```

Selected archetype:

```
maven-archetype-quickstart
```

It generated the standard Maven directory structure.

---

## ADDING SPRING DEPENDENCY

I added the following Spring Core dependency inside `pom.xml`:

```xml
<dependencies>
    <!-- Spring Core Context -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.9</version>
    </dependency>
</dependencies>
```

---

## CONFIGURATION FILE

I created a Spring XML config file in:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
          http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bookRepository" class="com.library.repository.BookRepository" />

    <bean id="bookService" class="com.library.service.BookService">
        <property name="bookRepository" ref="bookRepository" />
    </bean>

</beans>
```

---

## FUNCTION CLASSES

### `BookRepository.java`

```java
package com.library.repository;

public class BookRepository {
    public String getBookName() {
        return "The Spring in Action";
    }
}
```

---

### `BookService.java`

```java
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Book Name: " + bookRepository.getBookName());
    }
}
```

---

### `LibraryApp.java`

```java
package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.displayBook();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
```
---

## OUTPUT

```bash
Book Name: The Spring in Action
```