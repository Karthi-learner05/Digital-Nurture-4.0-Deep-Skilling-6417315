package WEEK_1_DesignPatternsAndPrinciples.HandsOn_3_BuilderPatternExample.code;

public class ComputerDetails {
    public String getDetails(Computer cmp){
        return "\n\tCPU     : "+cmp.getCPU()+"\n\tRAM :     "+cmp.getRAM()+"\n\tSTORAGE : "+cmp.getSTORAGE()+"\n";
    }
}
