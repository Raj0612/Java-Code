package DesignPatterns.Creational.ObjectPool.email;


public class Client {
    public static void main(String[] args){
        //Create Multiple Email Sender Threads
        for(int i=0; i<10; i++){
            new EmailSender(i).start();
        }
    }
}
