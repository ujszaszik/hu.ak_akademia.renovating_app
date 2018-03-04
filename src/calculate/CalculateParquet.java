package calculate;

import revonating_item.Parquet;

public class CalculateParquet extends WorkersWaste implements Operation, Formatting, Monetary {
	
	public double priceForParquet(RoomData rd) {
		return totalParquetUsedWithWaste(rd) * Parquet.RUSTIC_WOOD.getPrice();
	}
	
	@Override
	public double priceInEuro(RoomData rd) {
		return priceForParquet(rd) / Currency.EURO.getExchange();
	}
	
	private int totalParquetUsedWithWaste(RoomData rd) {
		return (int) (Math.ceil(useUpForWorkers(totalParquetUsedWithoutWaste(rd))));
	}
	
	private int totalParquetUsedWithoutWaste(RoomData rd) {
		return parquetUsedForRoomLength(rd) * parquetUsedForRoomWidth(rd);
	}
	
	private int parquetUsedForRoomLength(RoomData rd) {
		return (int) (Math.ceil(rd.getLength() / Parquet.RUSTIC_WOOD.getLength()));
	}
	
	private int parquetUsedForRoomWidth(RoomData rd) {
		return (int) (Math.ceil(rd.getWidth() / Parquet.RUSTIC_WOOD.getWidth()));
	}

	@Override
	public String toString(RoomData rd) {
		return "A szoba " + nf.format(rd.getSurfaceOfFloor()) + " n�gyzetm�ter�t kell leparkett�zni." + 
			 "\n\nEhhez " + nf.format(totalParquetUsedWithWaste(rd)) + " darab parkett�ra lesz sz�ks�g." + 
			 "\nEnnek teljes k�lts�ge " + nf.format(priceForParquet(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).";
	}

	@Override
	public String totalString(RoomData rd) {
		return "Parketta: " + nf.format(priceForParquet(rd)) + " HUF (= " + nf.format(priceInEuro(rd)) + " EUR).\n";
	}

}
