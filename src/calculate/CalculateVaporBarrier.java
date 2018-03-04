package calculate;

import revonating_item.Foil;

public class CalculateVaporBarrier extends CalculateFoil {

	@Override
	public double surfaceOfFoilInOneRoll() {
		return Foil.VAPOR_BARRIER.getLength() * Foil.VAPOR_BARRIER.getWidth();
	}

	@Override
	public double priceForFoiling(RoomData rd) {
		return rollsUsedForFoiling(rd) * Foil.VAPOR_BARRIER.getPrice();
	}
	
	@Override
	public String toString(RoomData rd) {
		return "�sszesen " + nf.format(rd.getSurfaceOfFloor()) + " n�gyzetm�ternyi ter�letet kell lef�li�zni.\n"  + 
			 "\nEhhez �sszesen " + rollsUsedForFoiling(rd) + " csomag p�raz�r�f�li�t kell v�s�rolni." + 
			 "\nEnnek �ra " + nf.format(priceForFoiling(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR)." + 
			 "\nA munk�latok v�g�n megmarad: " + nf.format(remainingFoilsAfterWork(rd)) + " nm. p�raz�r�f�lia.";
	}

	@Override
	public String totalString(RoomData rd) {
		return "P�raz�r�: " + nf.format(priceForFoiling(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).\n";
	}

}
