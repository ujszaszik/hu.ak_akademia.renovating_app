package calculate;

public class RoomData {
	private double height;
	private double width;
	private double length;
	private double toLift;

	public RoomData(double height, double width, double length, double toLift) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.toLift = toLift;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getToLift() {
		return toLift;
	}

	public double getSurfaceOfWalls() {
		return 2 * (width + length) * height;
	}
	
	public double getCircumference() {
		return 2 * (width + length);
	}
	
	public double getVolumeToLift() {
		return width * length * toLift;
	}
	
	public double getSurfaceOfFloor() {
		return width * length;
	}
	
	public double getAirspace() {
		return width * length * height;
	}

}
