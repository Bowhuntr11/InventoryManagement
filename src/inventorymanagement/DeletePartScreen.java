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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sherrill
 */
public class DeletePartScreen {
    
        
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


