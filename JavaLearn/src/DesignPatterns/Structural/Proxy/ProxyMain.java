package DesignPatterns.Structural.Proxy;


interface InternetAccess{
    void grantInternetAccess();
}

class InternetAccessImpl implements InternetAccess{

    @Override
    public void grantInternetAccess(){
        System.out.println("Granting internet Access");
    }
}

class ProxyInternetAccess implements InternetAccess{
    private  final InternetAccessImpl internetAccess;
    private String user ="";

     public ProxyInternetAccess(String user,InternetAccessImpl internetAccess){
         this.internetAccess = internetAccess;
         this.user = user;
     }
    @Override
    public void grantInternetAccess(){
        if(hasInternetAccess())
            internetAccess.grantInternetAccess();
        else
            System.out.println("No Internet Access granted");
    }


    private boolean hasInternetAccess(){
        if(user == "admin")
            return true;
        else
            return false;
    }
}

public class ProxyMain {

    public static void main(String[] args) {
        ProxyInternetAccess proxy = new ProxyInternetAccess("admin", new InternetAccessImpl());
        proxy.grantInternetAccess();
    }
}