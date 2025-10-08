package DesignPatterns.Creational.Prototype.GameUnit;

//Doesn't support cloning
public class General extends GameUnit{

	private String state = "idle";
	
	public void boostMorale() {
		this.state = "MoralBoost";
	}


	@Override
	public GameUnit clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Ganerals are unique");
	}

	@Override
	protected void reset() {
		throw new UnsupportedOperationException("Reset not supported");
	}

	@Override
	public String toString() {
		return "General "+state+" @ "+getPosition();
	}
}
