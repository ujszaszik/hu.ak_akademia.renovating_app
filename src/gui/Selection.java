package gui;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Selection {

	private Selection() {
	}

	protected static Selection isChecked(CheckBox checkbox, Label labelToPutText, String textToLabel, 
										 Label cumulatedMessage, String textToCumulatedLabel, double sumOfPrice) {
		if (checkbox.isSelected()) {
			labelToPutText.setText(textToLabel);
			Result.addStringAndPriceForCumulatedCalculation(textToCumulatedLabel, sumOfPrice);
		} else {
			labelToPutText.setText("");
		}
		Result.setMessageForCumulatedPrice(cumulatedMessage);
		return new Selection();
	}

}
