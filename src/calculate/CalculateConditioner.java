package calculate;

import revonating_item.Conditioner;

public class CalculateConditioner implements Operation, Formatting, Monetary {
	private String selectedType;
	private double selectedPrice;

	public double getSelectedPrice() {
		return selectedPrice;
	}
	
	public void selectConditionerToUse(RoomData rd) {
		if (rd.getSurfaceOfFloor() < 25) {
			selectSmallType();
		} else if (rd.getSurfaceOfFloor() >= 25 && rd.getSurfaceOfFloor() < 40) {
			selectMediumType();
		} else {
			selectLargeType();
		}
	}
	

	@Override
	public double priceInEuro(RoomData rd) {
		return selectedPrice / Currency.EURO.getExchange();
	}

	private void selectLargeType() {
		selectedType = Conditioner.LARGE.getName();
		selectedPrice = Conditioner.LARGE.getPrice();
	}

	private void selectMediumType() {
		selectedType = Conditioner.MEDIUM.getName();
		selectedPrice = Conditioner.MEDIUM.getPrice();
	}

	private void selectSmallType() {
		selectedType = Conditioner.SMALL.getName(); 
		selectedPrice = Conditioner.SMALL.getPrice();
	}
	
	private double totalAirspaceOfRoom(RoomData rd) {
		return rd.getAirspace();
	}
	
	@Override
	public String toString(RoomData rd) {
		return "A szoba �sszesen " + nf.format(totalAirspaceOfRoom(rd)) + " l�gk�bm�teres." + 
				"\n\nAj�nlott l�gkondicion�l� ''" + selectedType + "''" + 
				"\nA k�sz�l�k �ra " + nf.format(selectedPrice) + " HUF (= " + nf.format(priceInEuro(rd))  + " EUR).";
	}

	@Override
	public String totalString(RoomData rd) {
		return "L�gkondi: " + nf.format(selectedPrice) + " HUF (= " + nf.format(priceInEuro(rd))  + " EUR).";
	}

}
