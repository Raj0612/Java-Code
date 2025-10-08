package DesignPatterns.Creational.Builder.geekforgeeks;

public interface Builder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}
