package calculate;

public interface Foiling extends Formatting, Operation {
	
	double surfaceOfFoilInOneRoll();
	
	int rollsUsedForFoiling(RoomData rd);
	
	double remainingFoilsAfterWork(RoomData rd);
	
	double priceForFoiling(RoomData rd);
}
