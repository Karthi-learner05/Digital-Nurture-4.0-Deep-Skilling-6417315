# JPA vs Hibernate vs Spring Data JPA

In this project, I explored and implemented the **three main persistence techniques in Java**:

1. **Hibernate Only** – Using Hibernate as an ORM framework directly
2. **JPA Only** – Using Java Persistence API (`EntityManager`)
3. **Spring Data JPA** – Spring abstraction over JPA for reducing boilerplate

Each was implemented in its **own directory** with separate `pom.xml`, configs, and models.

---

## Hibernate Only

### Dependencies (`pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.4.4.Final</version>
    </dependency>
    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>
</dependencies>
```

### Programs Created

#### `Employee.java`

```java
package com.example.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;

    // getters and setters
}
```

#### `HibernateUtil.java`

```java
package com.example.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
```

#### `App.java`

```java
package com.example.hibernate;

import com.example.hibernate.model.Employee;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setName("Karthik");
        emp.setSalary(60000);

        session.save(emp);
        tx.commit();
        session.close();
    }
}
```

---

## JPA Only

### Dependencies (`pom.xml`)

(Same as Hibernate – Hibernate is JPA provider)

### Programs Created

#### `Employee.java`

Same as Hibernate model.

#### `persistence.xml` (in `src/main/resources/META-INF/`)

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">
    <persistence-unit name="jpa-unit" transaction-type="RESOURCE_LOCAL">
        <class>com.example.jpa.model.Employee</class>
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/your_database"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="Karthi123@"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

#### `App.java`

```java
package com.example.jpa;

import com.example.jpa.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager em = emf.createEntityManager();

        Employee emp = new Employee();
        emp.setName("Karthik");
        emp.setSalary(70000);

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
```

---

## Spring Data JPA

### Dependencies (`pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>
</dependencies>
```

### Programs Created

#### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=Karthi123@
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

#### `Employee.java`

Same model as Hibernate.

#### `EmployeeRepository.java`

```java
package com.example.springdata.repository;

import com.example.springdata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

#### `EmployeeService.java`

```java
package com.example.springdata.service;

import com.example.springdata.model.Employee;
import com.example.springdata.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```

#### `App.java`

```java
package com.example.springdata;

import com.example.springdata.model.Employee;
import com.example.springdata.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public void run(String... args) {
        Employee emp = new Employee();
        emp.setName("Spring Data Kutty");
        emp.setSalary(88000);
        employeeService.addEmployee(emp);
    }
}
```

---

## Comparison Table

| Feature                 | Hibernate Only      | JPA Only             | Spring Data JPA               |
|-------------------------|---------------------|-----------------------|-------------------------------|
| API Used                | `SessionFactory`    | `EntityManager`       | `JpaRepository`               |
| Configuration Style     | `hibernate.cfg.xml` | `persistence.xml`     | `application.properties`      |
| Code Complexity         | High                | Medium                | Very Low                      |
| Boilerplate             | High                | Medium                | Minimal                       |
| Framework Abstraction   | Direct ORM          | Standard API          | Spring Boot abstraction layer |
| Transaction Handling    | Manual              | Manual                | Spring managed                |