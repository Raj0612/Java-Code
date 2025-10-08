package learn.designpattern.dimitrinesteruk.creational.singletom;

public class InnerStaticSingleton {

    private InnerStaticSingleton(){

    }

    private static class Impl{
        private static final InnerStaticSingleton instance = new InnerStaticSingleton();
    }

   public InnerStaticSingleton getInstance(){
        return  Impl.instance;
   }
}
