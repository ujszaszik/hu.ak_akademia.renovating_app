package revonating_item;

public enum Concrete implements Purchaseable {
	X_FLOOR(25, 2500, 15, 2);

	private final double bagSize;
	private final double price;
	private final double minLift;
	private final double unitAmmount;

	private Concrete(double bagSize, double price, double minLift, double unitAmmount) {
		this.bagSize = bagSize;
		this.price = price;
		this.minLift = minLift;
		this.unitAmmount = unitAmmount;
	}

	public double getBagSize() {
		return bagSize;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public double getMinLift() {
		return minLift;
	}

	public double getUnitAmmount() {
		return unitAmmount;
	}

}
