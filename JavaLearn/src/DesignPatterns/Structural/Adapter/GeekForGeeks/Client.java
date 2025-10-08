package DesignPatterns.Structural.Adapter.GeekForGeeks;

public class Client {

    public static void main(String[] args) {
        PrinterAdapter adapter = new PrinterAdapter(new LegacyPrinter());

        adapter.print();
    }
}
