package DesignPatterns.Behavioral.ChainOfResponsibility.baeldungauthentication;

public class OAuthProcessor extends BaeldungAuthenticationProcessor {

    public OAuthProcessor(BaeldungAuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(BaeldungAuthenticationProcessor authProvider) {
        System.out.println("OAuthProcessor authProvider " + authProvider);
        if (authProvider instanceof OAuthProcessor) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }

        return false;
    }
}
