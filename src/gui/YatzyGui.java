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

public class YatsyGui extends Application {
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
        label1.setPrefWidth(123);

        // Opret label2
        Label label2 = new Label("2");
        label2.setPrefWidth(60);

        // Opret Button
        Button btnKastTerninger = new Button("Kast terningerne");
        btnKastTerninger.setPrefWidth(108);
        // link button med action-metode
        btnKastTerninger.setOnAction(event -> this.btnKastTerningerAction());

        // Opret HBox
        HBox blandetBox = new HBox(37);
        blandetBox.getChildren().addAll(label1, label2, btnKastTerninger);

        // tilføj til tredje række
        gridPane.add(blandetBox, 0, 2, 5, 1);

//  ====================================================================================================================

        // Opret buttons til kombinationer
        String[] kombiButtonKategorier = {"1'ere", "2'ere", "3'ere", "4'ere", "5'ere", "6'ere", "Et par", "To par", "Tre ens", "Fire ens", "Fuldt hus", "Den lille", "Den store", "Chance", "Yatzy"};

        Button[] kombiButtons = new Button[kombiButtonKategorier.length];

        // Loop gennem alle knapperne
        for (int i = 0; i < kombiButtonKategorier.length; i++) {
            // Opret knap med navnet fra arrayet
            Button kombiButton = new Button(kombiButtonKategorier[i]);
            kombiButton.setPrefSize(80, 20);

            // Gem knappen i kombiButtons arrayet
            kombiButtons[i] = kombiButton;
        }

        // Opret labels til resultater i hovedet
        Label label9 = new Label("Sum");
        Label label10 = new Label("Bonus");
        Label label20 = new Label("Total");

        // Opbygning af labelfelter med Array
        Label[] pointLabels = new Label[18];

            // Opret og konfigurer hver pointLabel i arrayet
        for (int j = 0; j < pointLabels.length; j++) {
            pointLabels[j] = new Label();
            pointLabels[j].setPrefSize(50, 25);
            pointLabels[j].setStyle("-fx-border-color: gray; -fx-background-color: white; -fx-border-width: 1; -fx-border-radius: 2;");
            }

//  ====================================================================================================================

        // Tilføj labels til hovedet
        gridPane2.add(kombiButtons[0], 0, 0, 1, 1);
        // kombiButtons[0].setOnAction(event -> this.addEttere());
        gridPane2.add(kombiButtons[1], 0, 1, 1, 1);
        // kombiButtons[1].setOnAction(event -> this.addToere());
        gridPane2.add(kombiButtons[2], 0, 2, 1, 1);
        // kombiButtons[2].setOnAction(event -> this.addTreere());
        gridPane2.add(kombiButtons[3], 0, 3, 1, 1);
        // kombiButtons[3].setOnAction(event -> this.addFirere());
        gridPane2.add(kombiButtons[4], 0, 4, 1, 1);
        // kombiButtons[4].setOnAction(event -> this.addFemmere());
        gridPane2.add(kombiButtons[5], 0, 5, 1, 1);
        // kombiButtons[5].setOnAction(event -> this.addSeksere());
        gridPane2.add(label9, 2, 6, 1, 1);
        gridPane2.add(label10, 2, 7, 1, 1);
        // Tilføj tekstfelter til hovedet
        gridPane2.add(pointLabels[0],1,0);
        gridPane2.add(pointLabels[1], 1, 1);
        gridPane2.add(pointLabels[2], 1, 2);
        gridPane2.add(pointLabels[3], 1, 3);
        gridPane2.add(pointLabels[4], 1, 4);
        gridPane2.add(pointLabels[5], 1, 5);
        gridPane2.add(pointLabels[6], 3, 6);
        gridPane2.add(pointLabels[7], 3, 7);

        // tilføj labels til kombis
        gridPane2.add(kombiButtons[6], 0, 8, 1, 1);
        // kombiButtons[6].setOnAction(event -> this.addEtPar());
        gridPane2.add(kombiButtons[7], 0, 9, 1, 1);
        // kombiButtons[7].setOnAction(event -> this.addToPar());
        gridPane2.add(kombiButtons[8], 0, 10, 1, 1);
        // kombiButtons[8].setOnAction(event -> this.addTreEns());
        gridPane2.add(kombiButtons[9], 0, 11, 1, 1);
        // kombiButtons[9].setOnAction(event -> this.addFireEns());
        gridPane2.add(kombiButtons[10], 0, 12, 1, 1);
        // kombiButtons[10].setOnAction(event -> this.addFuldtHus());
        gridPane2.add(kombiButtons[11], 0, 13, 1, 1);
        // kombiButtons[11].setOnAction(event -> this.addDenLille());
        gridPane2.add(kombiButtons[12], 0, 14, 1, 1);
        // kombiButtons[12].setOnAction(event -> this.addDenStore());
        gridPane2.add(kombiButtons[13], 0, 15, 1, 1);
        // kombiButtons[13].setOnAction(event -> this.addChance());
        gridPane2.add(kombiButtons[14], 0, 16, 1, 1);
        // kombiButtons[14].setOnAction(event -> this.addYatzy());
        gridPane2.add(label20, 2, 17, 1, 1);

        // Tilføj pointLabels til kombinationer
        gridPane2.add(pointLabels[8], 1, 8);
        gridPane2.add(pointLabels[9], 1, 9);
        gridPane2.add(pointLabels[10], 1, 10);
        gridPane2.add(pointLabels[11], 1, 11);
        gridPane2.add(pointLabels[12], 1, 12);
        gridPane2.add(pointLabels[13], 1, 13);
        gridPane2.add(pointLabels[14], 1, 14);
        gridPane2.add(pointLabels[15], 1, 15);
        gridPane2.add(pointLabels[16], 1, 16);
        gridPane2.add(pointLabels[17], 3, 17);

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
        Scene scene = new Scene(mainVBox, 338, 735);
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
            yatzyResultCalculator.upperSectionScore(rafleBæger.getDice()[i].getEyes());
            for (int j = 0; j < 6; j++) {
                if (rafleBæger.getDice()[i].getEyes() == rafleBæger.getDice()[i + j].getEyes())
                    yatzyResultCalculator.onePairScore();
            }
        }
    }

    public void checkboxesAction(ActionEvent event) {
        CheckBox checkBox = (CheckBox) event.getSource();
        int index = (int) checkBox.getUserData();
        rafleBæger.flipHoldDie(index);
    }}
