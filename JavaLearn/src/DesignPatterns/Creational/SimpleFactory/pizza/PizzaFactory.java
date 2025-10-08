package DesignPatterns.Creational.SimpleFactory.pizza;

public class PizzaFactory {

    public static Pizza createPizza(String type){
        Pizza p = null;

        if(type.equals("Cheese"))
            p = new PizzaCheese();
        else if(type.equals("Chicken"))
            p = new PizzaChicken();
        else if(type.equals("Veg"))
            p = new PizzaVeg();

        p.prepare();
        p.bake();
        p.cut();
        return p;
    }
}
