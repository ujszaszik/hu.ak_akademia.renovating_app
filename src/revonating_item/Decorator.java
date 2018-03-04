package revonating_item;

public enum Decorator implements Rollable, Purchaseable {
	DIEGO_ROYAL(0.53, 10, 5, 12990);
	
	private final double width;
	private final double length;
	private final double patternLength;
	private final double price;

	private Decorator(double width, double length, double patternLength, double price) {
		this.width = width;
		this.length = length;
		this.patternLength = patternLength;
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
	
	public double getPatternLength() {
		return patternLength;
	}
	
	public double getSurfaceOfOneRoll() {
		return width * length;
	}
}
