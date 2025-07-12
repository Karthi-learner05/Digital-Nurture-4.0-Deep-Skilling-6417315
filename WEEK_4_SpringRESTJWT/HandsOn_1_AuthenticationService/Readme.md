# REST - JWT Authentication Service

In this project, I created a RESTful Authentication Service using Spring Boot 3 and Spring Security 6. The service exposes an `/authenticate` endpoint that accepts Basic Auth credentials via the `Authorization` header, decodes them, and returns a JWT token if valid. The JWT is generated using the `jjwt` API.

---

## Dependencies

`pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

---

## JwtUtil.java

```java
package com.cognizant.jwt_auth_service.jwt_auth_service.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "ThisIsASecretKeyForJWTSigningDontUseInProduction";
    private final long expirationMs = 1000 * 60 * 60;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
```

---

## TokenResponse.java

```java
package com.cognizant.jwt_auth_service.jwt_auth_service.model;

public class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
```

---

## AuthenticationController.java

```java
package com.cognizant.jwt_auth_service.jwt_auth_service.controller;

import com.cognizant.jwt_auth_service.jwt_auth_service.model.TokenResponse;
import com.cognizant.jwt_auth_service.jwt_auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decoded = Base64.getDecoder().decode(base64Credentials);
            String[] credentials = new String(decoded).split(":", 2);
            String username = credentials[0];
            String password = credentials[1];

            // You can validate username/password here

            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(new TokenResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
        }
    }
}
```

---

## SecurityConfig.java

```java
package com.cognizant.jwt_auth_service.jwt_auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());

        return http.build();
    }
}
```

---

## JwtAuthServiceApplication.java

```java
package com.cognizant.jwt_auth_service.jwt_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtAuthServiceApplication.class, args);
    }
}
```

---

## Testing

To authenticate and get a token, use:

```bash
curl -s -u user:pwd http://localhost:8080/authenticate
```

Sample Response:

```json
{"token":"eyJhbGciOiJIUzI1NiJ9..."}
```