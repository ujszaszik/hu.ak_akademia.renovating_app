package revonating_item;

public enum Foil implements Purchaseable, Rollable {
	VAPOR_BARRIER(1.50, 50.0, 7750.0), 
	FOAM_SHEET(1.2, 120.0, 23686.0);

	private final double width;
	private final double length;
	private final double price;

	private Foil(double width, double length, double price) {
		this.width = width;
		this.length = length;
		this.price = price;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
