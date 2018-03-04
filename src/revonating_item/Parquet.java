package revonating_item;

public enum Parquet implements Purchaseable {
	RUSTIC_WOOD(2.2, 0.192, 7190);

	private final double length;
	private final double width;
	private final double price;
	
	private Parquet(double length, double width, double price) {
		this.length = length;
		this.width = width;
		this.price = price;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

}
