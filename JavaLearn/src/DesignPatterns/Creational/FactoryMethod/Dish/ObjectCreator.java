package DesignPatterns.Creational.FactoryMethod.Dish;

public class ObjectCreator {

    Dish dish;

    public ObjectCreator(DishFactory dishFactory){
        dish = dishFactory.createDish();
    }

   public Dish getDish(){
        return this.dish;
    }
}
