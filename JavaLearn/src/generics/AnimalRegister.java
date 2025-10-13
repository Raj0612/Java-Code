package generics;

class Register<T, U, V>{
    private T type;
    private U name;
    private V age;
    
    Register(T type, U name, V age){
        this.type = type;
        this.name = name;
        this.age  = age;
    }
    public T getType(){ 
        return type;
    }
    public U getName(){ 
        return name;
    }
    public V getAge(){ 
        return age;
    }
}
public class AnimalRegister {
    public static void main(String[] args) {
        Register<Dog, String, Integer> register = new Register<>(new Dog(), "Shep", 3);
        Register register1 = new Register(new Cat(), "Whiskers", 2);
        System.out.println("Type " + register.getType() + " name " + register.getName() + " age " + register.getAge());
        System.out.println("Type " + register1.getType() + " name " + register1.getName() + " age " + register1.getAge());
    }
}

class Dog{

    public void move(){
        System.out.println("Dog is moving");
    }
}

class Cat{
    public void move(){
        System.out.println("Cat is moving");
    }
}



