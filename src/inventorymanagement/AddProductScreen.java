
package inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Sherrill
 */
public class AddProductScreen {
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    private final Label idLabel = new Label("ID");
    private final Label nameLabel = new Label("Name");
    private final Label invLabel = new Label("Inv");
    private final Label priceLabel = new Label("Price");
    private final Label maxLabel = new Label("Max");
    
    private final TextField idBox = new TextField("Auto Gen - Disabled");
    private final TextField nameBox = new TextField("Product Name");
    private final TextField invBox = new TextField("Inv");
    private final TextField priceBox = new TextField("Price");
    private final TextField maxBox = new TextField("Max");
    private final TextField minBox = new TextField("Min");
    private final Label minLabel = new Label("Min");
    
    private Product newProduct = new Product();
    private final TableView<Part> rightTopTable = new TableView();
    private final TableView<Part> rightBotTable = new TableView();
            
    
    
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
        
        // Save Product
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction((ActionEvent e) -> {
            newProduct.setProductID();
            newProduct.setName(nameBox.getText());
            newProduct.setInstock(Integer.parseInt(invBox.getText()));
            newProduct.setPrice(Integer.parseInt(priceBox.getText()));
            newProduct.setMax(Integer.parseInt(maxBox.getText()));
            newProduct.setMin(Integer.parseInt(minBox.getText()));
            Inventory.addProduct(newProduct);
            stage.close();
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            newProduct = null;
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
            Button searchPartsTop = new Button("Search");
            
            // Middle Add Button - It makes sure a part hasn't already been added
            HBox addBtnHBox = new HBox();
            addBtnHBox.setPadding(new Insets(15, 5, 5, 335));
            Button addBtn = new Button("Add");
                addBtn.setOnAction((ActionEvent e) -> {
                    if (!rightBotTable.getItems().contains(rightTopTable.getSelectionModel().getSelectedItem())) {
                    newProduct.addPart(rightTopTable.getSelectionModel().getSelectedItem());
                    }
                    else {
                        System.out.println("Already added!");
                    }
                });
                        
            addBtn.setMinWidth(75);
            addBtnHBox.getChildren().addAll(addBtn);
            
            // Bottom Delete Button
            HBox delBtnHBox = new HBox();
            delBtnHBox.setPadding(new Insets(15, 5, 5, 335));
            Button delBtn = new Button("Delete");
            delBtn.setOnAction((ActionEvent e) -> {
                Part part = rightBotTable.getSelectionModel().getSelectedItem();
                newProduct.removePart(part.getPartID());
            });
            delBtn.setMinWidth(75);
            delBtnHBox.getChildren().addAll(delBtn);
            
            // Parts Search Field
            TextField searchField = new TextField("Part ID");
            searchField.setMaxWidth(200);
            searchHBox.getChildren().addAll(searchPartsTop, searchField);
            
            // Parts Search Button Action - Finds the part in Inventory by Part IDthen adds it to 
            // a new ObservableList to populate the tableview
            searchPartsTop.setOnAction((ActionEvent e) -> {
                Part part = Inventory.lookupPart(Integer.parseInt(searchField.getText()));
                ObservableList<Part> searchPart = FXCollections.observableArrayList();
                searchPart.add(part);
                rightTopTable.setItems(searchPart);
            });
            
            rightLayout.getChildren().addAll(searchHBox, rightTopTableBox(), addBtnHBox
                                                , rightBottomTableBox(), delBtnHBox);
            return rightLayout;
        }
        
        public VBox rightTopTableBox() {
            
            TableColumn partID = new TableColumn("Part ID");
            partID.setCellValueFactory(
                    new PropertyValueFactory<>("partID"));
            
            TableColumn partName = new TableColumn("Part Name");
            partName.setCellValueFactory(
                    new PropertyValueFactory<>("name"));
            partName.setMinWidth(100); // Setting Column width to minimum so 
                                            // that user doesn't have to resize it
                                            
            TableColumn invLevelParts = new TableColumn("Inventory Level");
            invLevelParts.setCellValueFactory(
                    new PropertyValueFactory<>("instock"));
            invLevelParts.setMinWidth(100);
            
            TableColumn pricePart = new TableColumn("Price per Unit");  
            pricePart.setCellValueFactory(
                    new PropertyValueFactory<>("price")); 
            pricePart.setMinWidth(130);
            
            rightTopTable.setItems(Inventory.getPARTS());
            rightTopTable.getColumns().addAll(partID, partName, invLevelParts, pricePart);
            
            final VBox topTable = new VBox();
            topTable.setMaxHeight(150);
            topTable.setPadding(new Insets(10, 150, 0, 0));
            topTable.getChildren().addAll(rightTopTable);
            return topTable;
        }
        
        public VBox rightBottomTableBox() {
            TableColumn partID = new TableColumn("Part ID");
            partID.setCellValueFactory(
                    new PropertyValueFactory<>("partID"));
            
            
            TableColumn partName = new TableColumn("Part Name");
            partName.setCellValueFactory(
                    new PropertyValueFactory<>("name"));
            partName.setMinWidth(100); // Setting Column width to minimum so 
                                            // that user doesn't have to resize it
                                            
                                            
            TableColumn invLevelParts = new TableColumn("Inventory Level");
            invLevelParts.setCellValueFactory(
                    new PropertyValueFactory<>("instock"));
            invLevelParts.setMinWidth(100);
            
            
            TableColumn pricePart = new TableColumn("Price per Unit");   
            pricePart.setCellValueFactory(
                    new PropertyValueFactory<>("price"));
            pricePart.setMinWidth(130);
            
            rightBotTable.setItems(newProduct.getParts());
            rightBotTable.getColumns().addAll(partID, partName, invLevelParts, pricePart);
            
            final VBox botTable = new VBox();
            botTable.setMaxHeight(150);
            botTable.setPadding(new Insets(20, 150, 0, 0));
            botTable.getChildren().addAll(rightBotTable);
            return botTable;
        }
}
