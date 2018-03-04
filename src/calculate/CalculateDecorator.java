package calculate;

import revonating_item.Decorator;

public class CalculateDecorator extends WorkersWaste implements Operation, Formatting, Monetary {
	
	public int priceOfDecorator(RoomData rd) {
		return (int) (decoratorRollsToBuy(rd) * Decorator.DIEGO_ROYAL.getPrice());
	}
	
	@Override 
	public double priceInEuro(RoomData rd) {
		return priceOfDecorator(rd) / Currency.EURO.getExchange();
	}
	
	private int decoratorRollsToBuy(RoomData rd) {
		double temp = surfaceToDecorate(rd) / Decorator.DIEGO_ROYAL.getSurfaceOfOneRoll();
		return (int) Math.ceil(temp);
	}
	
	private double surfaceToDecorate(RoomData rd) {
		return useUpForWorkers(surfaceToDecorateWithoutWaste(rd));
	}
	
	private double surfaceToDecorateWithoutWaste(RoomData rd) {
		return decoratorSurfacePerSlide(rd) * decoratorSlidesPerRoom(rd);
	}

	private double decoratorSurfacePerSlide(RoomData rd) {
		return decoratorHeightPerSlide(rd) * Decorator.DIEGO_ROYAL.getWidth(); 
	}
	
	private double decoratorHeightPerSlide(RoomData rd) {
		return rd.getHeight() + dustDecoratorPerSlide(rd);
	}
	
	private double dustDecoratorPerSlide(RoomData rd) {
		return Decorator.DIEGO_ROYAL.getPatternLength() - (rd.getHeight() % Decorator.DIEGO_ROYAL.getPatternLength());
	}
	
	private int decoratorSlidesPerRoom(RoomData rd) {
		double temp = rd.getCircumference() / Decorator.DIEGO_ROYAL.getWidth();
		return (int) Math.ceil(temp);
	}
	
	@Override
	public String toString(RoomData rd) {
		return "A kitap�t�zand� ter�let �sszesen " + nf.format(rd.getSurfaceOfWalls()) + " n�gyzetm�ter." +
			  "\n\nEhhez " + nf.format(decoratorRollsToBuy(rd)) + " guriga tap�t�t kell v�s�rolni." + 
			"\nEnnek az �ra �sszesen " + nf.format(priceOfDecorator(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).";	
	}

	@Override
	public String totalString(RoomData rd) {
		return "Tap�ta: " + nf.format(priceOfDecorator(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).\n";
	}
	
}
