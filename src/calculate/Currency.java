package calculate;

public enum Currency {
	EURO(309.99);

	private double exchange;

	private Currency(double exchange) {
		this.exchange = exchange;
	}

	public double getExchange() {
		return exchange;
	}
}
