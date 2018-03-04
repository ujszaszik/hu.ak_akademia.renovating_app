package calculate;

import calculate.Foiling;

public abstract class CalculateFoil extends WorkersWaste implements Operation, Foiling, Monetary {

	protected double surfaceToFoilWithWaste(RoomData rd) {
		return useUpForWorkers(rd.getLength() * rd.getWidth());
	}
	
	@Override
	public double priceInEuro(RoomData rd) {
		return priceForFoiling(rd) / Currency.EURO.getExchange();
	}

	@Override
	public int rollsUsedForFoiling(RoomData rd) {
		return (int) Math.ceil(surfaceToFoilWithWaste(rd) / surfaceOfFoilInOneRoll());
	}

	@Override
	public double remainingFoilsAfterWork(RoomData rd) {
		return rollsUsedForFoiling(rd) * surfaceOfFoilInOneRoll() - surfaceToFoilWithWaste(rd);
	}

}
