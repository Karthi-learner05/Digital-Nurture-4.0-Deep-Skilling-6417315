# SETTING UP JUNIT

In this project i worked to setting up the new JUnit project in VSCode. For that I have installed extensions such as Java Extension pack,Maven and Junit Test runner.

-----------------------------

## CREATING NEW PROJECT

I have used query ``` Maven : Create new Project ``` in VS code command palette to create an new Maven JUnit project.

## ADDING DEPENDANCY

I have added the dependancy for the Junit in the project using the ```pom.xml``` file.

``` xml

<dependency>
    <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    <scope>test</scope>
</dependency>

```

## TEST CLASSES

For checking whether the Junit working or not I have implemented simle calculater test.

*** ``` Calculator.java ``` ***

``` java

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

```
*** ``` CalculatorTest.java ``` ***

``` java

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(10, 5);
        assertEquals(15, result);
    }
}

```

## TESTING

I have tested my Test is working or not using the terminal command
            ``` bash
                mvn test
            ```

``` bash

[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]

```