package DesignPatterns.Behavioral.ChainOfResponsibility.RefactoringGuru;

public abstract class Middleware {

    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return false;
        }
        return next.check(email, password);
    }
}
