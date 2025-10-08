package learn.java8features.functionalinterfaces;

@FunctionalInterface
public interface FunctioanIntf {

    int calculate(int val);

    static int calculate1(int val){
        return 0;
    }

    default int calculate2(int val){
        return 0;
    }

    default int eqq(int val){
        return 0;
    }

    public boolean equals(Object o);
}
