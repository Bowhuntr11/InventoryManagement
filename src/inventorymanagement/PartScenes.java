/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Sherrill
 */
public class PartScenes {
    
    public void addPart() {
        Stage stage = new Stage();
        BorderPane bp = new BorderPane();
        ToggleGroup radio = new ToggleGroup();
        
        // Top Items on Add Part Screen
        HBox top = new HBox();
        top.setSpacing(20);
        top.setPadding(new Insets(15, 12, 15, 12));
        Label label = new Label("Add Part");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        label.setPadding(new Insets(0, 50, 0, 0));
        RadioButton inHouse = new RadioButton();
        inHouse.setToggleGroup(radio);
        Label inHouseLabel = new Label("In-House");
        RadioButton outsourced = new RadioButton();
        outsourced.setToggleGroup(radio);
        Label outsourcedLabel = new Label("Outsourced");
        top.getChildren().addAll(label, inHouse, inHouseLabel, outsourced, outsourcedLabel);
        
        // Left Labels on Add Part Screen
        VBox left = new VBox();
        left.setSpacing(30);
        left.setPadding(new Insets(15, 5, 5, 75));
        
        Label idLabel = new Label("ID");
        Label nameLabel = new Label("Name");
        Label invLabel = new Label("Inv");
        Label priceLabel = new Label("Price/Cost");
        Label maxLabel = new Label("Max");
        Label compLabel = new Label("Company Name");
        
        left.getChildren().addAll(idLabel, nameLabel, invLabel, priceLabel,
                maxLabel, compLabel);
        
        // Right Text Fields on Add Part Screen
        VBox right = new VBox();
        right.setSpacing(22);
        right.setPadding(new Insets(10, 125, 5, 5));
        TextField idBox = new TextField("Auto Gen - Disabled");
        idBox.setDisable(true);
        idBox.setMaxWidth(125);
        
        TextField nameBox = new TextField("Part Name");
        nameBox.setMaxWidth(100);
        
        TextField invBox = new TextField("Inv");
        invBox.setMaxWidth(100);
        
        TextField priceBox = new TextField("Price/Cost");
        priceBox.setMaxWidth(100);
        
        TextField maxBox = new TextField("Max");
        maxBox.setMaxWidth(50);
        
        TextField companyBox = new TextField("Comp Nm");
        companyBox.setMaxWidth(100);
        
        right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                maxBox, companyBox);
        /*
        btnCancel.setOnAction((ActionEvent event) -> {
            stage.close(); // return to main window
        });
        */
        
        bp.setTop(top);
        bp.setLeft(left);
        bp.setRight(right);
        
        Scene scene = new Scene(bp, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public void modifyPart() {
        Stage stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        // How to center align content in a layout manager in JavaFX
        box.setAlignment(Pos.CENTER);

        Label label = new Label("Enter username and password");

        TextField textUser = new TextField();
        textUser.setPromptText("enter user name");
        TextField textPass = new TextField();
        textPass.setPromptText("enter password");

        Button btnLogin = new Button();
        btnLogin.setText("Login");

        btnLogin.setOnAction((ActionEvent event) -> {
            // Assume success always!
            stage.close(); // return to main window
        });

        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public void deletePart() {
        Stage stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        // How to center align content in a layout manager in JavaFX
        box.setAlignment(Pos.CENTER);

        Label label = new Label("Enter username and password");

        TextField textUser = new TextField();
        textUser.setPromptText("enter user name");
        TextField textPass = new TextField();
        textPass.setPromptText("enter password");

        Button btnLogin = new Button();
        btnLogin.setText("Login");

        btnLogin.setOnAction((ActionEvent event) -> {
            // Assume success always!
            stage.close(); // return to main window
        });

        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
}
