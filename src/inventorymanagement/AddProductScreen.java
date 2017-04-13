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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Sherrill
 */
public class AddProductScreen {
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    final private Label idLabel = new Label("ID");
    final private Label nameLabel = new Label("Name");
    final private Label invLabel = new Label("Inv");
    final private Label priceLabel = new Label("Price");
    final private Label maxLabel = new Label("Max");
    
    final private TextField idBox = new TextField("Auto Gen - Disabled");
    final private TextField nameBox = new TextField("Product Name");
    final private TextField invBox = new TextField("Inv");
    final private TextField priceBox = new TextField("Price");
    final private TextField maxBox = new TextField("Max");
    final private TextField minBox = new TextField("Min");
    final private Label minLabel = new Label("Min");
    
    
    public void addProduct() {
        Stage stage = new Stage();
        BorderPane mainPane = new BorderPane();
        BorderPane leftPane = new BorderPane();
        BorderPane rightPane = new BorderPane();

        // Buttons on Bottom
        HBox btns = new HBox();
        btns.setAlignment(Pos.CENTER_RIGHT);
        btns.setSpacing(20);
        btns.setPadding(new Insets(0, 100, 20, 0));
        
        // Need to Fix save Button
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction((ActionEvent e) -> {
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            stage.close();
        });
        
        btns.getChildren().addAll(saveBtn, cancelBtn);
        
        // Organizing overall layout
        mainPane.setLeft(leftPane);
        mainPane.setRight(rightPane);
        mainPane.setBottom(btns);
        
        // Organizing left side of layout
        leftPane.setTop(addProductTop());
        leftPane.setLeft(addProductLabels());
        leftPane.setRight(addProductTextBoxes());
        
        // Organizing right side of layout
        rightPane.setCenter(rightLayout());
        
        
        Scene scene = new Scene(mainPane, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }
    
        // Top Items on Add Product Screen
        public HBox addProductTop() {
            HBox top = new HBox();
            top.setSpacing(20);
            top.setPadding(new Insets(100, 12, 15, 100));
            Label label = new Label("Add Product");
            label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            label.setPadding(new Insets(0, 50, 0, 0));
            
            top.getChildren().addAll(label);

            return top;
        }
        
        // Labels on Left of Add Product Screen
        public VBox addProductLabels() {
            VBox left = new VBox();
            left.setSpacing(30);
            left.setPadding(new Insets(45, 5, 5, 75));
            
            left.getChildren().addAll(idLabel, nameLabel, invLabel, priceLabel,
                    maxLabel);
            
            return left;
        }
        
        // Right Text Fields on Add Product Screen
        public VBox addProductTextBoxes() {
            VBox right = new VBox();
            right.setSpacing(25);
            right.setPadding(new Insets(40, 125, 5, 5));
            idBox.setFont(ITALICS);
            idBox.setDisable(true);
            idBox.setMaxWidth(125);
            
            nameBox.setFont(ITALICS);
            nameBox.setMaxWidth(100);
            
            invBox.setFont(ITALICS);
            invBox.setMaxWidth(100);
            
            priceBox.setFont(ITALICS);
            priceBox.setMaxWidth(100);

            HBox maxMin = new HBox();
            
            maxBox.setFont(ITALICS);
            maxBox.setMaxWidth(50);
            
            minLabel.setPadding(new Insets(0, 15, 0, 15));
            
            minBox.setFont(ITALICS);
            minBox.setMaxWidth(50);
            maxMin.getChildren().addAll(maxBox, minLabel, minBox);

            right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                    maxMin);
            
            return right;
        }
        
        public VBox rightLayout() {
            VBox rightLayout = new VBox();
            
            // Top Search Button
            HBox searchHBox = new HBox();
            searchHBox.setSpacing(15);
            searchHBox.setPadding(new Insets(75, 150, 0, 100));
            Button searchProducts = new Button("Search");
            
            // Middle Add Button
            HBox addBtnHBox = new HBox();
            addBtnHBox.setPadding(new Insets(15, 5, 5, 335));
            Button addBtn = new Button("Add");
            addBtn.setMinWidth(75);
            addBtnHBox.getChildren().addAll(addBtn);
            
            // Bottom Delete Button
            HBox delBtnHBox = new HBox();
            delBtnHBox.setPadding(new Insets(15, 5, 5, 335));
            Button delBtn = new Button("Delete");
            delBtn.setMinWidth(75);
            delBtnHBox.getChildren().addAll(delBtn);
            
            // Parts Search Field
            TextField searchField = new TextField();
            searchField.setMaxWidth(200);
            searchHBox.getChildren().addAll(searchProducts, searchField);
            
            rightLayout.getChildren().addAll(searchHBox, rightTopTable(), addBtnHBox
                                                , rightBottomTable(), delBtnHBox);
            return rightLayout;
        }
        
        public VBox rightTopTable() {
            TableView rightTable = new TableView();
            TableColumn productID = new TableColumn("Part ID");
            TableColumn productName = new TableColumn("Part Name");
            productName.setMinWidth(100); // Setting Column width to minimum so 
                                            // that user doesn't have to resize it
            TableColumn invLevelProducts = new TableColumn("Inventory Level");
            invLevelProducts.setMinWidth(100);
            TableColumn priceProduct = new TableColumn("Price per Unit");   
            priceProduct.setMinWidth(130);
            rightTable.getColumns().addAll(productID, productName, invLevelProducts, priceProduct);
            final VBox topTable = new VBox();
            topTable.setMaxHeight(150);
            topTable.setPadding(new Insets(10, 150, 0, 0));
            topTable.getChildren().addAll(rightTable);
            return topTable;
        }
        
        public VBox rightBottomTable() {
            TableView rightBotTable = new TableView();
            TableColumn productID = new TableColumn("Part ID");
            TableColumn productName = new TableColumn("Part Name");
            productName.setMinWidth(100); // Setting Column width to minimum so 
                                            // that user doesn't have to resize it
            TableColumn invLevelProducts = new TableColumn("Inventory Level");
            invLevelProducts.setMinWidth(100);
            TableColumn priceProduct = new TableColumn("Price per Unit");   
            priceProduct.setMinWidth(130);
            rightBotTable.getColumns().addAll(productID, productName, invLevelProducts, priceProduct);
            final VBox botTable = new VBox();
            botTable.setMaxHeight(150);
            botTable.setPadding(new Insets(20, 150, 0, 0));
            botTable.getChildren().addAll(rightBotTable);
            return botTable;
        }
}
