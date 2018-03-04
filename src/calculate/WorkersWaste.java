package calculate;

public abstract class WorkersWaste implements Waste {
	
	@Override
	public double useUpForWorkers(double a) {
		return a * UseUp.WORKERS.getPercentage();
	}

}
