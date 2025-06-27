# AAA and TEARDOWN

In this project I implemented the``` AAA``` pattern and ```teardown``` process to perform test on my own calculator class. By this greater maintainablity and space release after usage was achieved.

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
## FUNCTION CLASS

This class is responsible for holding the functonalities and which will be tested by an test class.

*** ``` Calculators.java ``` ***

``` java

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

```

## TEST CLASSES

This class is responsible for testing Calculator class. I have implemented AAA pattern to write test and teardown process to free the memory after each test completion.


*** ``` MathUtilsTest.java ``` ***

``` java

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("🔧 Setup complete.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("🧹 Teardown complete.\n");
    }

    @Test
    public void testAddition() {
        int a = 10;
        int b = 5;

        int result = calculator.add(a, b);

        System.out.println("Addition Result: " + result);
        assertEquals("Addition failed", 15, result);
    }

    @Test
    public void testMultiplication() {

        int x = 4;
        int y = 3;

        int product = calculator.multiply(x, y);

        System.out.println("Multiplication Result: " + product);
        assertEquals("Multiplication failed", 12, product);
    }

    @Test
    public void testIsEven() {

        int num = 6;

        boolean result = calculator.isEven(num);

        System.out.println("Is " + num + " even? " + result);
        assertTrue("Should be even", result);
    }
}

```

#### *** AAA PATTERN ***

AAA Pattern was used to arrange , act and assert code in very efficient way. In the Test class I have done this by the following,

```Arrange```

In every Test conducted such as ***testIsEven()*** , ***testMutiplication()*** and ***testAddition()*** I have arranged the date needed as an parameter earlier to the test execution. Like,

``` java

        int x = 4;
        int y = 3;

```

```Act```

Each test was act upon by the created funtions and parameters which are arranged. It was done earlier to the assertion which will help to seperate the process of assertion and action. Like

``` java

        int result = calculator.add(a, b);

```

```Assert```

After the Arrange and act is completed this assert operation comes to the play where it involves in the real test indication to the all the tests.Llike,

``` java

        assertTrue("Should be even", result);

```

### SETUP and TEARDOWN

I have made setup and ddone teardown process using the Annotations ```Befor``` and ```After``` whch was used to perform the setup operation and teardown operation befor and after each tests respectively.

*** Setup ***

``` java

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("🔧 Setup complete.");
    }

```

*** After ***

``` java

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("🧹 Teardown complete.\n");
    }

```

## TESTING

I have tested my assertion functionalities Test is working or not using the terminal command

            ``` bash
                mvn test
            ```

``` bash

[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]

```