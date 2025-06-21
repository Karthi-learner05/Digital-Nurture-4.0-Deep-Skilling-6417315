# Financial Forecasting

This solution was used to predict the future value of an ```Initial Value``` based on the ```AnnualGrowthrate``` and the ```Years```.

## Recursion

Recursion is a programming technique where a method calls itself to solve a smaller instance of the same problem.

**It reduces complex repetitive logic into simpler, self-repeating rules.
**It’s ideal when a problem can be broken into smaller subproblems.

## Financial Class

This class was used to make an financial instance for every single account. Along with that I maintained ```Builder Pattern``` to reduce complexity to create an instance for the account.

```Financial.java```

``` java
public class Financial {
    private double initialInvestment;
    private double annualGrowthRate;
    private int years;

    public Financial(FinancialBuilder builder) {
        this.initialInvestment = builder.initialInvestment;
        this.annualGrowthRate = builder.annualGrowthRate;
        this.years = builder.years;
    }

    public double getInitialInvestment() {
        return initialInvestment;
    }
    public double getAnnualGrowthRate() {
        return annualGrowthRate;
    }
    public int getYears() {
        return years;
    }

    public static class FinancialBuilder {
        private double initialInvestment;
        private double annualGrowthRate;
        private int years;

        public FinancialBuilder(double initialInvestment) {
            this.initialInvestment = initialInvestment;
        }

        public FinancialBuilder setAnnualGrowthRate(double annualGrowthRate) {
            this.annualGrowthRate = annualGrowthRate;
            return this;
        }

        public FinancialBuilder setYears(int years) {
            this.years = years;
            return this;
        }

        public Financial build() {
            return new Financial(this);
        }
    }
}

```

## Recurive Method

This method was used to Recursively calculate the future price of the investment. Along with that I maintained ```SRP``` by creating seperate class for the calculation functionality.

```CalculateFinancial.java```

``` java

public class CalculateFinancial {
    private double initialvalue;
    private double annualGrowthRate;
    private int years;

    public CalculateFinancial(Financial financial) {
            this.initialvalue=financial.getInitialInvestment();
            this.annualGrowthRate=financial.getAnnualGrowthRate();
            this.years=financial.getYears();
    }

    public void calculateFutureValue() {
        System.out.println("The Future Value is "+futureValue(initialvalue, annualGrowthRate/100, years));
    }

    public static double futureValue(double initialValue, double rate, int years) {
        if (years == 0) return initialValue;
        return futureValue(initialValue, rate, years - 1) * (1 + rate);
    }
}

```

## Client Code

This is the code section where clients and users are allowed to see and visible to them.

``` java

public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Initial Investment Amount: ");
        double initialInvestment = in.nextDouble();
        System.out.print("Enter Annual Growth Rate (in %): ");
        double annualGrowthRate = in.nextDouble();
        System.out.print("Enter Number of Years: ");
        int years = in.nextInt();
        Financial financial = new Financial.FinancialBuilder(initialInvestment)
                .setAnnualGrowthRate(annualGrowthRate)
                .setYears(years)
                .build();
        CalculateFinancial calculateFinancial = new CalculateFinancial(financial);
        in.close();
        calculateFinancial.calculateFutureValue();
    }
}

```