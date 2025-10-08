package DesignPatterns.Creational.SimpleFactory.pizza;

public class PizzaStore {

    public Pizza orderPizzaFromPizzaStore(String type){
        System.out.println("From Pizza Store:");
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

    public Pizza orderPizzaFromPizzaFactory(String type){
        System.out.println("From Pizza Factory:");
        Pizza p = PizzaFactory.createPizza(type);
        return p;
    }
}
