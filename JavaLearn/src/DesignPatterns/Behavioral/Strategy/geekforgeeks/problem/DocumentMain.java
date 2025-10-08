package DesignPatterns.Behavioral.Strategy.geekforgeeks.problem;

 class Document {

    private String text;

    public Document(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void save(String format){
        if(format.equals("plain")){
            System.out.println("Saving as plain text: " + text);
        }else if(format.equals("html")) {
            System.out.println("Saving as HTML <html><body> " + text + "</body></html>");
        }else{
            System.out.println("Unknown format: "+ format);
        }
    }

}
public class DocumentMain{
     public static void main(String[] args) {

         Document doc = new Document("Hello World");
         doc.save("plain");
         doc.save("html");
       }

 }