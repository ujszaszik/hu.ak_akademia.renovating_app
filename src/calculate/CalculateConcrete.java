package calculate;

import revonating_item.Concrete;

public class CalculateConcrete extends WorkersWaste implements Operation, Formatting, Monetary {
	
	public int priceOfConcrete(RoomData rd) {
		return (int) (bagsOfConcreteNeeded(rd) * Concrete.X_FLOOR.getPrice());
	}
	
	@Override
	public double priceInEuro(RoomData rd) {
		return priceOfConcrete(rd) / Currency.EURO.getExchange();
	}

	private int bagsOfConcreteNeeded(RoomData rd) {
		double temp = totalAmmountForLifting(rd) / Concrete.X_FLOOR.getBagSize();
		return (int) Math.ceil(temp);
	}
	
	private double totalConcreteRemainingAfterWork(RoomData rd) {
		double remaining = Concrete.X_FLOOR.getBagSize() - (totalAmmountForLifting(rd) % Concrete.X_FLOOR.getBagSize());
			if (remaining == Concrete.X_FLOOR.getBagSize()) {
				return 0; 
		} else {
			return remaining;
		}
		
	}
	
	private double totalAmmountForLifting(RoomData rd) {
		return useUpForWorkers(totalAmmountForLiftingWithoutWaste(rd));
	}
	
	private double totalAmmountForLiftingWithoutWaste(RoomData rd) {
		return rd.getVolumeToLift() * Concrete.X_FLOOR.getUnitAmmount();
	}
	
	@Override
	public String toString(RoomData rd) {
		return "A szoba szintj�nek emel�se " + nf.format(rd.getVolumeToLift()) + " m2/mm t�rfogategys�g." + 
				"\n\nEhhez �sszesen " + nf.format(bagsOfConcreteNeeded(rd)) + " zs�k betonra lesz sz�ks�g." + 
				"\nEnnek �sszk�lts�ge " + nf.format(priceOfConcrete(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR)." +  
				"\nA munka v�gezt�vel megmarad " + nf.format(totalConcreteRemainingAfterWork(rd)) + " kilogramm beton.";
	}

	@Override
	public String totalString(RoomData rd) {
		return "Beton: " + nf.format(priceOfConcrete(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).\n";
	}


}
