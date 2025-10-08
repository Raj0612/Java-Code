package DesignPatterns.Behavioral.Observer.baeldung;

public class Client {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();
        observable.addObserver(observer);
        observable.setNews("news");
        System.out.println("observer.getNews() " + observer.getNews());

        ONewsAgency observable1 = new ONewsAgency();
        ONewsChannel observer1 = new ONewsChannel();
        observable1.addObserver(observer1);
        observable1.setNews("news");
        System.out.println("observer1.getNews() " + observer1.getNews());


        PCLNewsAgency observable2 = new PCLNewsAgency();
        PCLNewsChannel observer2 = new PCLNewsChannel();
        observable2.addPropertyChangeListener(observer2);
        observable.setNews("news");
        System.out.println("observer2.getNews() " + observer2.getNews());
    }
}
