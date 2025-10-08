package DesignPatterns.Structural.Adapter.GeekForGeeks;

public class PrinterAdapter implements  Printer{
    LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter){
        this.legacyPrinter = legacyPrinter;

    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
