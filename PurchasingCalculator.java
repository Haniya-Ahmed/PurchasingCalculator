/**
	This class represents Purchasing Calculator.
	@author Haniya Ahmed
*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.text.NumberFormat; 

public class PurchasingCalculator extends Application
{
   	 private TextField UnitPrice;
	 private TextField Quantity;
	 private Text PurchaseInfo;
	 private Text subTotal;
	 private Text salestax;
	 private Text totalCost;
	 private final double TAX_RATE = 0.15;

	NumberFormat nf = NumberFormat.getCurrencyInstance();

	public static void main(String[] args)
	{
	  launch(args);
	}


	public void start(Stage primaryStage)
   	{

		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(50);
		pane.setVgap(20);

	     	Label inputLabel1 = new Label("Unit Price:");
		pane.getChildren().add(inputLabel1);


		UnitPrice = new TextField();
        	UnitPrice.setPrefWidth(100);
		pane.getChildren().add(UnitPrice);
	      

		Label inputLabel2 = new Label("Quantity:");
		pane.getChildren().add(inputLabel2);


		Quantity= new TextField();
        	Quantity.setPrefWidth(100);
		pane.getChildren().add(Quantity);


		Button Calculate = new Button("Calculate");
        	Calculate.setOnAction(this::processCalculateButton);
		pane.getChildren().add(Calculate);
	

		Button Clear = new Button("Clear");
        	Clear.setOnAction(this::processClearButton);
		pane.getChildren().add(Clear);


		
		PurchaseInfo = new Text("Enter the Purchase Information.");
		pane.getChildren().add(PurchaseInfo);

		subTotal = new Text("Purchase Subtotal:");
		pane.getChildren().add(subTotal);

		salestax = new Text("New Brunswick Sales Tax:");
		pane.getChildren().add(salestax);

		totalCost = new Text("Purchase Total:");
		pane.getChildren().add(totalCost);


        	Scene scene = new Scene(pane, 250, 400);
		primaryStage.setTitle("Purchasing Calculator");
        	primaryStage.setScene(scene);
        	primaryStage.show();

	      
	}


	public void processClearButton(ActionEvent event)
	{
		totalCost.setText("Purchase Total:");
		salestax.setText("New Brunswick Sales Tax:");
		subTotal.setText("Purchase Subtotal:");
		PurchaseInfo.setText("Enter the Purchase Information.");

		UnitPrice.setText("");
		Quantity.setText("");
	}

	
	public void processCalculateButton(ActionEvent event)
	{
		PurchaseInfo.setText("Purchase Cost Breakdown:");

		double unitprice = Double.parseDouble(UnitPrice.getText());
		double quantity = Double.parseDouble(Quantity.getText());  

		double subtotal = unitprice * quantity;
		subTotal.setText("Purchase Subtotal: " + nf.format(subtotal));

		double tax = subtotal * TAX_RATE;
		salestax.setText("Purchase Subtotal: " + nf.format(tax));

		double cost = subtotal + tax;
		totalCost.setText("Purchase Subtotal: " + nf.format(cost));		


	}

}
