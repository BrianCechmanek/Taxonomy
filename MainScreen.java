package com.cechmanek.taxonomy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class MainScreen extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("BugSearcher");
        primaryStage.setResizable(false);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        final Scene mainScene = new Scene(pane, 500, 750, Color.AZURE);

        VBox vbox = new VBox(5);

        //instantiate buttons... I would like to move this all to a function somewhere else....
		// buttonType, buttonSize, buttonPodia, buttonAntena, buttonbuttonEdible;
		// instead of addiing items, may switch to Choicebox(ObservableList<T> items)

        //choice boxes because of length of options ( ChoiceBox uses menus)
        final Label type = new Label("Type");
		final ChoiceBox<String> buttonType = new ChoiceBox<String>();
		buttonType.getItems().addAll("insect", "arachnoid", "Asari");
		//
		final Label size = new Label("Size");
		final ChoiceBox<String> buttonSize = new ChoiceBox<String>();
		buttonSize.getItems().addAll("Small", "Medium", "Large", "X-Large", "NOPE");
		//
		final Label antena = new Label("Antena");
		final ChoiceBox<String> buttonAntena = new ChoiceBox<String>();    //will change to Boolean
		buttonAntena.getItems().addAll("Yes", "No");
		//
		final Label edible = new Label("Edible");
		final ChoiceBox<String> buttonEdible = new ChoiceBox<String>();
		buttonEdible.getItems().addAll("No", "Yes", "Hope so");
		// combo boxes because of short length ( ComoBox uses ListView)
		final Label podia = new Label("Podia");
		final ComboBox<String> buttonPodia = new ComboBox<String>();
        buttonPodia.getItems().addAll("legs", "wings", "flippers", "whatever slugs have", "stingers", "suction cups", "levitation", "magnets", "jet propulsion", "red bull", "Hooves", "ectoplasm");
        // and a text field case to type in your own info if applicable (will be harder to handle, but fun
        final Label userInputLabel = new Label("Additional description:");
        final TextField userInputText = new TextField();
        userInputText.setPromptText("add a description...");
        //make the search button
        Button searchButton = new Button("Search");

        //make output text field. It'll start as just a Genus/species name, but will expand a paragraph below for detail, and a picture
        final Text answerText = new Text("Best Match:");
        final Text answerMatch = new Text("(answer appears here)"); //replace with answer variable when it's ready

        vbox.getChildren().addAll(type, buttonType, size, buttonSize, antena, buttonAntena, edible, buttonEdible, podia, buttonPodia, userInputLabel, userInputText, searchButton, answerText, answerMatch);
		vbox.setAlignment(Pos.TOP_CENTER);
		pane.add(vbox, 0, 0);
        primaryStage.setScene(mainScene);
        primaryStage.show();


        // Make the event handler for filling out fields and searching
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String[] query = new String[6];
				//this is pretty dumb right now. setting each of 6 inputs. need to make a loop somehow
				query[0] = buttonType.getValue();
				query[1] = buttonSize.getValue();
				query[2] = buttonAntena.getValue();
				query[3] = buttonEdible.getValue();
				query[4] = buttonPodia.getValue();
				query[5] = userInputText.getText();         // note that currently this will be a compound string. later I'll split and handle differently

				System.out.println("Value of query is: ");
				for (String item : query) {
					System.out.println(item);
				}


				// TODO make handler for null input
			}

        } );
	}
}

