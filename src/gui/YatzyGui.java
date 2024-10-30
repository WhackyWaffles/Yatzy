package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.RaffleCup;
import models.Die;

public class Gui extends Application {
    private RaffleCup rafleBæger = new RaffleCup();
    private String[] terningVærdier = new String[] {"0", "0", "0", "0", "0"};
    private Label terning1 = new Label(terningVærdier[0]);
    private Label terning2 = new Label(terningVærdier[1]);
    private Label terning3 = new Label(terningVærdier[2]);
    private Label terning4 = new Label(terningVærdier[3]);
    private Label terning5 = new Label(terningVærdier[4]);

    @Override
    public void start(Stage primaryStage) {

        // Opret GridPane
        GridPane gridPane = new GridPane();
        // Tilføj padding og afstand mellem celler
        gridPane.setPadding(new Insets(10)); // Padding omkring hele GridPane
        gridPane.setHgap(10); // Horisontal afstand mellem celler
        gridPane.setVgap(5); // Vertikal afstand mellem celler

//  ====================================================================================================================

        // Opret GridPane2
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10)); // Padding omkring hele GridPane
        gridPane2.setHgap(10); // Horisontal afstand mellem celler
        gridPane2.setVgap(5); // Vertikal afstand mellem celler

//  ====================================================================================================================

        // Opret VBox som hovedcontainer
        VBox mainVBox = new VBox(10);
        mainVBox.setPadding(new Insets(10));

//  ====================================================================================================================

        HBox terningHBox = new HBox(10);
        gridPane.add(terningHBox, 0, 0, 5, 1);

//  ====================================================================================================================


        // Opret labels til terninger

        terning1.setPrefSize(50, 50);
        terning2.setPrefSize(50, 50);
        terning3.setPrefSize(50, 50);
        terning4.setPrefSize(50, 50);
        terning5.setPrefSize(50, 50);

        terning1.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-border-radius: 10; -fx-alignment:center;");
        terning2.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-border-radius: 10; -fx-alignment:center;");
        terning3.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-border-radius: 10; -fx-alignment:center;");
        terning4.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-border-radius: 10; -fx-alignment:center;");
        terning5.setStyle("-fx-border-color: grey; -fx-border-width: 1; -fx-border-radius: 10; -fx-alignment:center;");

        terningHBox.getChildren().add(terning1);
        terningHBox.getChildren().add(terning2);
        terningHBox.getChildren().add(terning3);
        terningHBox.getChildren().add(terning4);
        terningHBox.getChildren().add(terning5);


//  ====================================================================================================================

        // Opret array til checkbokse
        CheckBox[] checkBoxes = new CheckBox[5];

        // Opret HBox til at holde checkbokse
        HBox checkBoxHBox = new HBox(13);

        // For-løkke til at oprette checkbokse
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new CheckBox("Hold");
            checkBoxes[i].setUserData(i);
            checkBoxHBox.getChildren().add(checkBoxes[i]);
            checkBoxes[i].setOnAction(event -> this.checkboxesAction(event));
        }
        // Tilføj til anden række
        gridPane.add(checkBoxHBox, 0, 1, 5, 1);

//  ====================================================================================================================

        // Opret label1
        Label label1 = new Label("Antal kast tilbage:");
        label1.setPrefWidth(95);

        // Opret label2
        Label label2 = new Label("2");

        // Opret Button
        Button btnKastTerninger = new Button("Kast terningerne");
        btnKastTerninger.setPrefWidth(115);
        // link button med action-metode
        btnKastTerninger.setOnAction(event -> this.btnKastTerningerAction());

        // Opret HBox
        HBox blandetBox = new HBox(37);
        blandetBox.getChildren().addAll(label1, label2, btnKastTerninger);

        // tilføj til tredje række
        gridPane.add(blandetBox, 0, 2, 5, 1);

//  ====================================================================================================================

        // Opret labels til resultater i hovedet
        Label label3 = new Label("1'ere");
        label3.setPrefWidth(150);
        Label label4 = new Label("2'ere");
        Label label5 = new Label("3'ere");
        Label label6 = new Label("4'ere");
        Label label7 = new Label("5'ere");
        Label label8 = new Label("6'ere");
        Label label9 = new Label("Sum");
        label9.setPrefWidth(150);
        Label label10 = new Label("Bonus");

        // Opret labels til kombinationer
        Label label11 = new Label("Et par");
        Label label12 = new Label("To par");
        Label label13 = new Label("3 ens");
        Label label14 = new Label("4 ens");
        Label label15 = new Label("Den lille");
        Label label16 = new Label("Den store");
        Label label17 = new Label("Fuldt hus");
        Label label18 = new Label("Chance");
        Label label19 = new Label("Yatzy");
        Label label20 = new Label("Total");

        // Opbygning af tekstfelter med Array
        TextField[] textFields = new TextField[18];

        // Opret og konfigurer hver TextField i array
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new TextField();
            textFields[i].setPrefWidth(120); // Sæt standardbredde til 70 pixels
        }

//  ====================================================================================================================

        // Tilføj labels til hovedet
        gridPane2.add(label3, 0, 0, 1, 1);
        gridPane2.add(label4, 0, 1, 1, 1);
        gridPane2.add(label5, 0, 2, 1, 1);
        gridPane2.add(label6, 0, 3, 1, 1);
        gridPane2.add(label7, 0, 4, 1, 1);
        gridPane2.add(label8, 0, 5, 1, 1);
        gridPane2.add(label9, 2, 6, 1, 1);
        gridPane2.add(label10, 2, 7, 1, 1);
        // Tilføj tekstfelter til hovedet
        gridPane2.add(textFields[0], 1, 0);
        gridPane2.add(textFields[1], 1, 1);
        gridPane2.add(textFields[2], 1, 2);
        gridPane2.add(textFields[3], 1, 3);
        gridPane2.add(textFields[4], 1, 4);
        gridPane2.add(textFields[5], 1, 5);
        gridPane2.add(textFields[6], 3, 6);
        gridPane2.add(textFields[7], 3, 7);

        // tilføj labels til kombinationer
        gridPane2.add(label11, 0, 8, 1, 1);
        gridPane2.add(label12, 0, 9, 1, 1);
        gridPane2.add(label13, 0, 10, 1, 1);
        gridPane2.add(label14, 0, 11, 1, 1);
        gridPane2.add(label15, 0, 12, 1, 1);
        gridPane2.add(label16, 0, 13, 1, 1);
        gridPane2.add(label17, 0, 14, 1, 1);
        gridPane2.add(label18, 0, 15, 1, 1);
        gridPane2.add(label19, 0, 16, 1, 1);
        gridPane2.add(label20, 2, 17, 1, 1);
        // Tilføj tekstfelter til kombinationer
        gridPane2.add(textFields[8], 1, 8);
        gridPane2.add(textFields[9], 1, 9);
        gridPane2.add(textFields[10], 1, 10);
        gridPane2.add(textFields[11], 1, 11);
        gridPane2.add(textFields[12], 1, 12);
        gridPane2.add(textFields[13], 1, 13);
        gridPane2.add(textFields[14], 1, 14);
        gridPane2.add(textFields[15], 1, 15);
        gridPane2.add(textFields[16], 1, 16);
        gridPane2.add(textFields[17], 3, 17);

//  ====================================================================================================================

        VBox frameVBox = new VBox(0);
        frameVBox.getChildren().add(gridPane);
        frameVBox.setStyle("-fx-border-color: black; -fx-border-width: 1");

        VBox labelVBox = new VBox(0);
        labelVBox.getChildren().add(gridPane2);
        labelVBox.setStyle("-fx-border-color: black; -fx-border-width: 1");

        mainVBox.getChildren().addAll(frameVBox, labelVBox);

//  ====================================================================================================================

        // Opret scene og vis den
        Scene scene = new Scene(mainVBox, 336, 730);
        primaryStage.setTitle("Yatzy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void btnKastTerningerAction() {
        rafleBæger.throwDice();
        for (int i = 0; i < rafleBæger.getDice().length; i++) {
            terningVærdier[i] = String.valueOf(rafleBæger.getDice()[i].getEyes());
            terning1.setText(terningVærdier[0]);
            terning2.setText(terningVærdier[1]);
            terning3.setText(terningVærdier[2]);
            terning4.setText(terningVærdier[3]);
            terning5.setText(terningVærdier[4]);
        }
    }

    public void checkboxesAction(ActionEvent event) {
        CheckBox checkBox = (CheckBox) event.getSource();
        int index = (int) checkBox.getUserData();
        rafleBæger.flipHoldDie(index);
    }
}
