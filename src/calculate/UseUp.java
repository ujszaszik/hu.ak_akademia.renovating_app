package calculate;

public enum UseUp {
	WORKERS(10.0);
	
	private final double percentage;
	
	private UseUp(double percentage) {
		this.percentage = percentage;
	}
	
	public double getPercentage() {
		return (100 + percentage) / 100;
	}

}
