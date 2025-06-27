# ASSERTION IN JUNIT

In this project I have worked with the various ```Assert``` functionalities in the Junit such as ``` assertEquals() ``` , ``` assertNull() ``` , ``` assertNotNull() ``` , ``` assertTrue() ``` and ``` assertFalse() ```.

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

This class is responsible for holding the functonalities and which will be tested ny an test class.

*** ``` MathUtils.java ``` ***

``` java

public class MathUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }

    public Integer getNullValue() {
        return null;
    }

    public String getNonNullString() {
        return "JUnit";
    }
}

```

## TEST CLASSES

This class is responsible for testing the MathUtil class file using JUnit. More than that I have also implemented some of the printing statement for better understanding rather then empty test demostration.

*** ``` MathUtilsTest.java ``` ***

``` java

import static org.junit.Assert.*;
import org.junit.Test;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    public void testMathUtilsFunctions() {
        System.out.println("✅ Starting MathUtils test...");

        int sum = mathUtils.add(2, 3);
        System.out.println("Addition Result: " + sum);
        assertEquals("Addition failed", 5, sum);

        boolean isPositive = mathUtils.isPositive(10);
        System.out.println("Is 10 Positive? " + isPositive);
        assertTrue("Number should be positive", isPositive);

        boolean isNegativePositive = mathUtils.isPositive(-5);
        System.out.println("Is -5 Positive? " + isNegativePositive);
        assertFalse("Number should not be positive", isNegativePositive);

        Integer nullValue = mathUtils.getNullValue();
        System.out.println("Null value: " + nullValue);
        assertNull("Should return null", nullValue);

        String str = mathUtils.getNonNullString();
        System.out.println("Non-null String: " + str);
        assertNotNull("Should not be null", str);

        System.out.println("✅ MathUtils test completed successfully!");
    }
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
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]

```