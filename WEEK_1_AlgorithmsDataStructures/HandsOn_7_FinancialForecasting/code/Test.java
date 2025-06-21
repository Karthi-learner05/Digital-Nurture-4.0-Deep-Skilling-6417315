package WEEK_1_AlgorithmsDataStructures.HandsOn_7_FinancialForecasting.code;

import java.util.Scanner;

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
