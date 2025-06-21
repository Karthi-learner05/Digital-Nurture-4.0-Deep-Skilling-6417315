package WEEK_1_AlgorithmsDataStructures.HandsOn_7_FinancialForecasting.code;

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