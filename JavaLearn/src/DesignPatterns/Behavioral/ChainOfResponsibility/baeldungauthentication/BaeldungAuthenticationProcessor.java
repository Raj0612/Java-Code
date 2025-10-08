package DesignPatterns.Behavioral.ChainOfResponsibility.baeldungauthentication;

public abstract class BaeldungAuthenticationProcessor {
    public BaeldungAuthenticationProcessor nextProcessor;

    BaeldungAuthenticationProcessor(BaeldungAuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthorized(BaeldungAuthenticationProcessor authProvider);
}
