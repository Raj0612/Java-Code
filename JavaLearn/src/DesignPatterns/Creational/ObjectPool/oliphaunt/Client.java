package DesignPatterns.Creational.ObjectPool.oliphaunt;


public class Client {
    public static void main(String[] args) {
        ObjectPool pool = new OliphauntPool();
        Oliphaunt oliphaunt1 =(Oliphaunt)pool.checkOut();
        Oliphaunt oliphaunt2 =(Oliphaunt)pool.checkOut();
        Oliphaunt oliphaunt3 = (Oliphaunt)pool.checkOut();
        pool.checkIn(oliphaunt1);
        pool.checkIn(oliphaunt2);
        Oliphaunt oliphaunt4 =(Oliphaunt)pool.checkOut();
        Oliphaunt oliphaunt5 =(Oliphaunt)pool.checkOut();
    }
}
