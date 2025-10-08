package DesignPatterns.Behavioral.ChainOfResponsibility.baeldungauthentication;

public class Client {

	public static void main(String[] args) {
		/*
		 * BaeldungAuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
		 * oAuthProcessor.isAuthorized(new UsernamePasswordProcessor(oAuthProcessor));
		 */

		BaeldungChainOfResponsibility chain = new BaeldungChainOfResponsibility();
		chain.process(new OAuthProcessor(null));
		System.out.println();
		chain.process(new UsernamePasswordProcessor(null));

	}
	}


class BaeldungChainOfResponsibility{
	BaeldungAuthenticationProcessor chain = new UsernamePasswordProcessor(new OAuthProcessor(null));

	
	public void process(BaeldungAuthenticationProcessor request) {
		chain.isAuthorized(request);
	}
}

