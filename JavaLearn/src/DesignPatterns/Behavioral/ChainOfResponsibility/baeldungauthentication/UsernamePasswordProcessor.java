package DesignPatterns.Behavioral.ChainOfResponsibility.baeldungauthentication;

public class UsernamePasswordProcessor extends BaeldungAuthenticationProcessor{

    public UsernamePasswordProcessor(BaeldungAuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(BaeldungAuthenticationProcessor authProvider) {
        System.out.println("UsernamePasswordProcessor authProvider " + authProvider);
        if (authProvider instanceof UsernamePasswordProcessor) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}
