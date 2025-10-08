package DesignPatterns.Structural.Composite.component;

/*
                                               Computer

                          Cabinent                                 Peripheral

                    HDD             MotherBoard          KeyBoard              Mouse

                                RAM             Processor
*/
public class Client {


    public static void main(String[] args) {

       // getResult1();
        getResult2();
    }

    static void getResult1(){
        Component hdd       = new Leaf("hdd" , 4000);
        Component keyboard  = new Leaf("keyboard",1000);
        Component mouse     = new Leaf("mouse",500);
        Component ram       = new Leaf("ram",3000);
        Component processor = new Leaf("Processor",10000);

        Composite computer = new Composite("computer");

        Composite motherboard = new Composite("motherboard");
        motherboard.add(ram);
        motherboard.add(processor);

        Composite peripherals = new Composite("peripherals");
        peripherals.add(keyboard);
        peripherals.add(mouse);

        Composite cabinet = new Composite("cabinet");
        cabinet.add(hdd);
        cabinet.add(motherboard);

        computer.add(cabinet);
        computer.add(peripherals);

        computer.showPrice();
    }


    static void getResult2(){

        Composite computer = new Composite("Computer");

        Composite peripherals = new Composite("peripherals");


        Composite cabinet = new Composite("cabinet");

        Component hdd       = new Leaf("hdd" , 4000);
        Component keyboard  = new Leaf("keyboard",1000);

        cabinet.add(hdd);
        cabinet.add(keyboard);
        computer.add(peripherals);
        computer.add(cabinet);


        computer.showPrice();

    }
}
