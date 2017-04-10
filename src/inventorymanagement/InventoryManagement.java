/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author Blake Sherrill
 */

public class InventoryManagement extends Application {
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(75, 50, 10, 50));

        Label label = new Label("Inventory Management System");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        bp.setTop(label);

        bp.setLeft(partsBorderPane());
        bp.setRight(productsBorderPane());

        Button btnBotton = new Button("EXIT");
        BorderPane.setAlignment(btnBotton, Pos.CENTER_RIGHT);
        bp.setBottom(btnBotton);

        Scene scene = new Scene(bp, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Left pane for Parts
    public BorderPane partsBorderPane() {
        BorderPane partsBP = new BorderPane();
        partsBP.setPadding(new Insets(50, 10, 100, 50));
        // partsBP.setStyle("-fx-border-color: black");
        partsBP.setMaxWidth(500);

        partsBP.setTop(leftTopBox());
        partsBP.setCenter(partsBox());
        partsBP.setBottom(leftBottomBox());

        return partsBP;
    }
    
    // Top portion of Left Parts Box
    public HBox leftTopBox() {
        HBox leftTop = new HBox();
        leftTop.setPadding(new Insets(15, 12, 15, 12));
        leftTop.setSpacing(10);

        // Parts Label
        Label leftLabel = new Label("Parts");
        leftLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        leftLabel.setPadding(new Insets(0, 125, 0, 0));

        // Parts Search Button
        Button searchParts = new Button("Search");
        
        // Parts Search Field
        TextField searchField = new TextField();
        searchField.setMaxWidth(200);

        leftTop.getChildren().addAll(leftLabel, searchParts, searchField);

        return leftTop;
    }
    
    // Table for Parts listing
    public VBox partsBox() {
        TableView leftTable = new TableView();
        TableColumn partID = new TableColumn("Part ID");
        TableColumn partName = new TableColumn("Part Name");
        TableColumn invLevel = new TableColumn("Inventory Level");
        invLevel.setMinWidth(100);
        TableColumn price = new TableColumn("Price/Cost per Unit");   
        price.setMinWidth(130);
        leftTable.getColumns().addAll(partID, partName, invLevel, price);
        final VBox partsBox = new VBox();
        partsBox.setMaxHeight(200);
        partsBox.getChildren().addAll(leftTable);

        return partsBox;
    }
    
    public HBox leftBottomBox() {
        HBox leftBottom = new HBox();
        leftBottom.setPadding(new Insets(15, 12, 15, 12));
        leftBottom.setSpacing(10);

        // Add Parts Button
        Button addBtn = new Button("Add");

        // Modify Parts Button
        Button modifyBtn = new Button("Modify");
        
        // Delete Parts Button
        Button deleteBtn = new Button("Delete");

        leftBottom.getChildren().addAll(addBtn, modifyBtn, deleteBtn);
        leftBottom.setAlignment(Pos.CENTER_RIGHT);

        return leftBottom;
    }
    
        public BorderPane productsBorderPane() {
        BorderPane products = new BorderPane();
        products.setPadding(new Insets(50, 50, 100, 10));
        products.setMaxWidth(500);

        products.setTop(leftTopBox());
        products.setCenter(partsBox());
        products.setBottom(leftBottomBox());

        return products;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
