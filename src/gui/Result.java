package gui;

import calculate.*;
import javafx.scene.control.Label;

public class Result implements Formatting {
	private static String totalString = "";
	private static double totalPrice;
	
	protected static void setFieldsToDefafult() {
		totalPrice = 0;
		totalString = "";
	}

	protected static void addStringAndPriceForCumulatedCalculation(String summary, double sum) {
		totalString += summary;
		totalPrice += sum;
	}
	
	protected static void setMessageForCumulatedPrice(Label totalMessage) {
		totalMessage.setText(totalString + "\n\nA fel�j�t�s teljes k�lts�ge: " + nf.format(totalPrice) + " HUF (= " +
				nf.format(totalPrice / Currency.EURO.getExchange()) + " EUR).");
	}
	
}
