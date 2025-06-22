package WEEK_1_DesignPatternsAndPrinciples.HandsOn_3_BuilderPatternExample.code;

public class Test {
    public static void main(String[] args) {
        Computer Gaming=new Computer
        .ComputerBuilder("AMD RYZEN 9")
        .setRAM("32 GB")
        .setSTORAGE("2TB SSD")
        .build();

        Computer AI=new Computer
        .ComputerBuilder("Intel i9")
        .setRAM("32 GB")
        .setSTORAGE("1TB SSD")
        .build();

        Computer Office=new Computer
        .ComputerBuilder("Intel i5")
        .setRAM("16 GB")
        .setSTORAGE("1TB HDD")
        .build();

        Computer Personal=new Computer
        .ComputerBuilder("Intel i5")
        .setRAM("16 GB")
        .setSTORAGE("512GB SSD")
        .build();

        ComputerDetails computerdetails=new ComputerDetails();
        System.out.println("Compuet specifications created...");
        System.out.println("Personal Computer - "+computerdetails.getDetails(Personal));
        System.out.println("Office Computer - "+computerdetails.getDetails(Office));
        System.out.println("Gaming Computer - "+computerdetails.getDetails(Gaming));
        System.out.println("AI Computer - "+computerdetails.getDetails(AI));
    }
}
