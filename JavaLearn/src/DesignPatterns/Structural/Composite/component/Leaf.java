package DesignPatterns.Structural.Composite.component;

public class Leaf implements Component{
   public  String name;
    Double price;
    public Leaf() {

    }
    public Leaf(String name,double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println(this.name + " price: " +this.price);
    }


    public void  getName(){
        System.out.println("name " + name);
    }
}
