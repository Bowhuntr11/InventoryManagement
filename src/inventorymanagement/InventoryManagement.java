/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
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

        // Exit Button
        Button exitBtn = new Button("EXIT");
        BorderPane.setAlignment(exitBtn, Pos.CENTER_RIGHT);
        bp.setBottom(exitBtn);
        exitBtn.setOnAction((ActionEvent e) -> {
            primaryStage.close();
        });

        Scene scene = new Scene(bp, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /*
    // BELOW IS FOR LEFT PANEL (PARTS)
    */ 
    
    // Left pane for Parts
    public BorderPane partsBorderPane() {
        BorderPane partsBP = new BorderPane();
        partsBP.setPadding(new Insets(50, 10, 100, 50));
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
        TableColumn invLevelParts = new TableColumn("Inventory Level");
        invLevelParts.setMinWidth(100); // Setting Column width to minimum so that user doesn't have to resize it
        TableColumn pricePart = new TableColumn("Price/Cost per Unit");   
        pricePart.setMinWidth(130); // Setting Column width to minimum so that user doesn't have to resize it
        leftTable.getColumns().addAll(partID, partName, invLevelParts, pricePart);
        final VBox partsBox = new VBox();
        partsBox.setMaxHeight(200); // Setting MaxHeight for the table so it doesn't run off the screen
        partsBox.getChildren().addAll(leftTable);

        return partsBox;
    }
    
    public HBox leftBottomBox() {
        HBox leftBottom = new HBox();
        leftBottom.setPadding(new Insets(15, 12, 15, 12));
        leftBottom.setSpacing(10);

        // Add Parts Button for Parts
        Button addBtnParts = new Button("Add");
        addBtnParts.setOnAction((ActionEvent e) -> {
            AddPartScreen addPartScene = new AddPartScreen();
            addPartScene.addPart();
        });
        
        // Modify Parts Button for Parts
        Button modifyBtnParts = new Button("Modify");
        modifyBtnParts.setOnAction((ActionEvent e) -> {
            ModifyPartScreen modPartScene = new ModifyPartScreen();
            modPartScene.modifyPart();
        });
        
        // Delete Parts Button for Parts
        Button deleteBtnParts = new Button("Delete");
        deleteBtnParts.setOnAction((ActionEvent e) -> {
            //NEED TO FIX
        });

        leftBottom.getChildren().addAll(addBtnParts, modifyBtnParts, deleteBtnParts);
        leftBottom.setAlignment(Pos.CENTER_RIGHT);

        return leftBottom;
    }
    
    
    /*
    // BELOW IS FOR RIGHT PANEL (PRODUCTS)
    */
        public BorderPane productsBorderPane() {
        BorderPane products = new BorderPane();
        
        // Arranging window
        products.setPadding(new Insets(50, 50, 100, 10));
        products.setMaxWidth(500);

        products.setTop(rightTopBox());
        products.setCenter(productsBox());
        products.setBottom(rightBottomBox());

        return products;
    }
    
        public HBox rightTopBox() {
        HBox rightTop = new HBox();
        rightTop.setPadding(new Insets(15, 12, 15, 12));
        rightTop.setSpacing(10);

        // Parts Label
        Label rightLabel = new Label("Products");
        rightLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        rightLabel.setPadding(new Insets(0, 125, 0, 0));

        // Parts Search Button
        Button searchProducts = new Button("Search");
        
        // Parts Search Field
        TextField searchField = new TextField();
        searchField.setMaxWidth(200);

        rightTop.getChildren().addAll(rightLabel, searchProducts, searchField);

        return rightTop;
    }    
    
    // Table for Products listing
    public VBox productsBox() {
        TableView rightTable = new TableView();
        TableColumn productID = new TableColumn("Product ID");
        TableColumn productName = new TableColumn("Product Name");
        // Setting Column width to minimum so that user doesn't have to resize it
        productName.setMinWidth(100);
        TableColumn invLevelProducts = new TableColumn("Inventory Level");
        invLevelProducts.setMinWidth(100);
        TableColumn priceProduct = new TableColumn("Price per Unit");   
        priceProduct.setMinWidth(130);
        rightTable.getColumns().addAll(productID, productName, invLevelProducts, priceProduct);
        final VBox productsBox = new VBox();
        productsBox.setMaxHeight(200);
        productsBox.getChildren().addAll(rightTable);

        return productsBox;
    }
        
    public HBox rightBottomBox() {
        HBox rightBottom = new HBox();
        rightBottom.setPadding(new Insets(15, 12, 15, 12));
        rightBottom.setSpacing(10);

        // Add Parts Button for Products
        Button addBtnProduct = new Button("Add");
        addBtnProduct.setOnAction((ActionEvent e) -> {
            AddProductScreen addProductScene = new AddProductScreen();
            addProductScene.addProduct();
        });
        
        // Modify Parts Button for Products
        Button modifyBtnProduct = new Button("Modify");
        
        // Delete Parts Button for Products
        Button deleteBtnProduct = new Button("Delete");

        rightBottom.getChildren().addAll(addBtnProduct, modifyBtnProduct, deleteBtnProduct);
        rightBottom.setAlignment(Pos.CENTER_RIGHT);

        return rightBottom;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
