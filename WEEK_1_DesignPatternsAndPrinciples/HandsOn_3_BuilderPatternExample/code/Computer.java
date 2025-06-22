package WEEK_1_DesignPatternsAndPrinciples.HandsOn_3_BuilderPatternExample.code;

public class Computer {
    private String CPU;
    private String RAM;
    private String STORAGE;

    private Computer(ComputerBuilder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.STORAGE=builder.STORAGE;
    }

    public String getCPU(){
        return this.CPU;
    }
    public String getRAM(){
        return this.RAM;
    }
    public String getSTORAGE(){
        return this.STORAGE;
    }


    public static class ComputerBuilder{
        private String CPU;
        private String RAM;
        private String STORAGE;
        public ComputerBuilder(String cpu){
            this.CPU=cpu;
        }

        public ComputerBuilder setRAM(String ram){
            this.RAM=ram;
            return this;
        }

        public ComputerBuilder setSTORAGE(String storage){
            this.STORAGE=storage;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
