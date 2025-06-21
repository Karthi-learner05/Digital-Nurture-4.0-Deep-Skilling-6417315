package WEEK_1_AlgorithmsDataStructures.HandsOn_7_FinancialForecasting.code;

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
