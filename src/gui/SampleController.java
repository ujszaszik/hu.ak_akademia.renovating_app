package gui;

import calculate.CalculateConcrete;
import calculate.CalculateConditioner;
import calculate.CalculateDecorator;
import calculate.CalculateFoamSheet;
import calculate.CalculateParquet;
import calculate.CalculateVaporBarrier;
import calculate.Range;
import calculate.RoomData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import revonating_item.Concrete;
import revonating_item.ConcreteException;

public class SampleController {

	@FXML private Label buttonPressed;
	@FXML private Label decoratorLabel;
	@FXML private Label concreteLabel;
	@FXML private Label parquetLabel;
	@FXML private Label foilLabel;
	@FXML private Label airspaceLabel;
	@FXML private Label totalLabel;
	@FXML private TextField height;
	@FXML private TextField width;
	@FXML private TextField length;
	@FXML private TextField toLift;
	@FXML private CheckBox decoratorCB;
	@FXML private CheckBox concreteCB;
	@FXML private CheckBox parquetCB;
	@FXML private CheckBox foilCB;
	@FXML private CheckBox airspaceCB;


	public void buttonAction(ActionEvent event) {
		try {
			double roomHeight = Double.parseDouble(height.getText());
			validateInterval(roomHeight);
			double roomWidth = Double.parseDouble(width.getText());
			validateInterval(roomWidth);
			double roomLength = Double.parseDouble(length.getText());
			validateInterval(roomLength);
			double roomToLift = Double.parseDouble(toLift.getText());
			validateInterval(roomToLift);
			validateLifting(roomToLift);
			RoomData roomdata = new RoomData(roomHeight, roomWidth, roomLength, roomToLift);
			buttonPressed.setText("");
			printOutResults(roomdata);
		} catch (NumberFormatException nfe) {
			buttonPressed.setText("Csak pozit�v eg�sz sz�mot adhatsz meg!");
		} catch (ConcreteException ce) {
			buttonPressed.setText("Legal�bb 15 mm-t kell emelni!");
		}
	}
	
	public void resetTextFields(ActionEvent event) {
		height.setText("");
		width.setText("");
		length.setText("");
		toLift.setText("");
	}

	private void validateLifting(double roomToLift) {
		if (roomToLift < Concrete.X_FLOOR.getMinLift()) {
			throw new ConcreteException();
		}
	}
	
	private void validateInterval(double number) {
		if (!(number >= Range.ofPositiveNumbers().getLow() && number <= Range.ofPositiveNumbers().getHigh())) {
			throw new NumberFormatException();
		}
	}
	
	private void printOutResults(RoomData rd) {
		printOutDecoratorResults(rd);
		printOutConcreteResults(rd);
		printOutParquetResults(rd);
		printOutFoilResults(rd);
		printOutAirspaceResults(rd);
		Result.setFieldsToDefafult();
	}

	private void printOutDecoratorResults(RoomData rd) {
		CalculateDecorator decor = new CalculateDecorator();
		Selection.isChecked(decoratorCB, decoratorLabel, decor.toString(rd), totalLabel, decor.totalString(rd), decor.priceOfDecorator(rd));
	}

	private void printOutConcreteResults(RoomData rd) {
		CalculateConcrete concrete = new CalculateConcrete();
		Selection.isChecked(concreteCB, concreteLabel, concrete.toString(rd), totalLabel, concrete.totalString(rd), concrete.priceOfConcrete(rd));
	}

	private void printOutParquetResults(RoomData rd) {
		CalculateParquet parquet = new CalculateParquet();
		Selection.isChecked(parquetCB, parquetLabel, parquet.toString(rd), totalLabel, parquet.totalString(rd), parquet.priceForParquet(rd));
	}

	private void printOutFoilResults(RoomData rd) {
		CalculateVaporBarrier vapor = new CalculateVaporBarrier();
		CalculateFoamSheet foam = new CalculateFoamSheet();
		Selection.isChecked(foilCB, foilLabel, vapor.toString(rd) + foam.toString(rd), totalLabel, vapor.totalString(rd) + foam.totalString(rd), vapor.priceForFoiling(rd) + foam.priceForFoiling(rd));
	}

	private void printOutAirspaceResults(RoomData rd) {
		CalculateConditioner conditioner = new CalculateConditioner();
		conditioner.selectConditionerToUse(rd);
		Selection.isChecked(airspaceCB, airspaceLabel, conditioner.toString(rd), totalLabel, conditioner.totalString(rd), conditioner.getSelectedPrice());
	}

}
