# BUILDER PATTER EXAMPLE

This invloves in the implementation of the ```Builder Pattern``` for building an computer.

## Computer Class

This class involves in creating an computer instance. It holds the computer specifications as private such as RAM,CPU and STORAGE.

```Computer.java```

``` java

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
}

```

## Builder Class

This class was created as static inside the ```Computer``` class to build an computer class.

```ComputerBuilder.java```

``` java

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

```

## Computer Details

I have created an seperate class for diplaying the computer specifications to maintain the SRP.

```ComputerDetails.java```

``` java

public class ComputerDetails {
    public String getDetails(Computer cmp){
        return "\n\tCPU     : "+cmp.getCPU()+"\n\tRAM :     "+cmp.getRAM()+"\n\tSTORAGE : "+cmp.getSTORAGE()+"\n";
    }
}

```

## Client Code

This was the test code used to showcase the ```Builder Class`` I have created previously.

```Test.java```

``` java

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

```