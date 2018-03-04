package calculate;

public class Range {

	private final double high;
	private final double low;

	public double getHigh() {
		return high;
	}
	public double getLow() {
		return low;
	}
	
	private Range(double low, double high) {
		this.high = high;
		this.low =  low;
	}

	public static Range of(double low, double high) {
		return new Range(Math.min(high, low),Math.max(high, low));
	}
	
	public static Range ofPositiveNumbers() {
		return new Range(10E-324, Double.MAX_VALUE);
	}
}
	