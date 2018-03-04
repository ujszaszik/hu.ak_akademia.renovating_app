package calculate;

import revonating_item.Foil;

public class CalculateFoamSheet extends CalculateFoil {

	@Override
	public double surfaceOfFoilInOneRoll() {
		return Foil.FOAM_SHEET.getLength() * Foil.FOAM_SHEET.getWidth();
	}

	@Override
	public double priceForFoiling(RoomData rd) {
		return rollsUsedForFoiling(rd) * Foil.FOAM_SHEET.getPrice();
	}
	
	@Override
	public String toString(RoomData rd) {
		return "\n\nSz�ks�ges tov�bb� " + nf.format(rollsUsedForFoiling(rd)) + " csomag habf�li�t is v�s�rolni." + 
			   "\nEnnek �ra: " + nf.format(priceForFoiling(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR)." + 
			   "\nA munk�latok v�g�n megmarad: " + nf.format(remainingFoilsAfterWork(rd)) + " nm. habf�lia.";
	}

	@Override
	public String totalString(RoomData rd) {
		return "Habf�lia: " + nf.format(priceForFoiling(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).\n";
	}

}
