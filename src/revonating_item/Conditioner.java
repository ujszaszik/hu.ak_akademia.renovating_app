package revonating_item;

public enum Conditioner implements Purchaseable {
	SMALL("HD HWI-094C", 126873),
	MEDIUM("HD HWI-124C", 139446),
	LARGE("HD-HDWI-183C", 216000);
	
	private final String name;
	private final double price;
	
	private Conditioner(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public double getPrice() {
		return price;
	}
}
