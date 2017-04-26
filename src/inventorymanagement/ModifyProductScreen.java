
package inventorymanagement;

import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class ModifyProductScreen {
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    final private Label idLabel = new Label("ID");
    final private Label nameLabel = new Label("Name");
    final private Label invLabel = new Label("Inv");
    final private Label priceLabel = new Label("Price");
    final private Label maxLabel = new Label("Max");
    final private Label minLabel = new Label("Min");
    
    final private TextField idBox = new TextField("");
    final private TextField nameBox = new TextField("");
    final private TextField invBox = new TextField("");
    final private TextField priceBox = new TextField("");
    final private TextField maxBox = new TextField("");
    final private TextField minBox = new TextField("");
    
    private Product newProduct = new Product();
    private final TableView<Part> rightTopTable = new TableView();
    private final TableView<Part> rightBottomTable = new TableView();
    
    
    public void modifyProduct(Product product) {
        Stage stage = new Stage();
        BorderPane mainPane = new BorderPane();
        BorderPane leftPane = new BorderPane();
        BorderPane rightPane = new BorderPane();

        // Buttons on Bottom
        HBox btns = new HBox();
        btns.setAlignment(Pos.CENTER_RIGHT);
        btns.setSpacing(20);
        btns.setPadding(new Insets(0, 100, 20, 0));
        
        // Save Button
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction((ActionEvent e) -> {
            newProduct.setProductID(product.getProductID());
            newProduct.setName(nameBox.getText());
            newProduct.setInstock(Integer.parseInt(invBox.getText()));
            newProduct.setPrice(Double.parseDouble(priceBox.getText()));
            newProduct.setMax(Integer.parseInt(maxBox.getText()));
            newProduct.setMin(Integer.parseInt(minBox.getText()));
            Inventory.updateProduct(product.getProductID(), newProduct);
            stage.close();
        });
        
        // Cancel Button
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            Alert confirmCancel = new Alert(Alert.AlertType.CONFIRMATION);
            confirmCancel.setTitle("Confirm Cancel");
            confirmCancel.setHeaderText("");
            confirmCancel.setContentText("Are you sure you want to exit without saving?");

            Optional<ButtonType> option = confirmCancel.showAndWait();
            if (option.get() == ButtonType.OK){
               stage.close();
            } else {
               mainPane.requestFocus();
            }
        });
        
        btns.getChildren().addAll(saveBtn, cancelBtn);
        
        // Organizing overall layout
        mainPane.setLeft(leftPane);
        mainPane.setRight(rightPane);
        mainPane.setBottom(btns);
        
        // Organizing left side of layout
        leftPane.setTop(modifyProductTop());
        leftPane.setLeft(modifyProductLabels());
        leftPane.setRight(modifyProductTextBoxes(product));
        
        // Organizing right side of layout
        rightPane.setCenter(rightLayout(product));
        
        
        Scene scene = new Scene(mainPane, 1000, 600);
        stage.setScene(scene);
        stage.show();
        mainPane.requestFocus();
    }
    
        // Top Items on Modify Product Screen
        public HBox modifyProductTop() {
            HBox top = new HBox();
            top.setSpacing(20);
            top.setPadding(new Insets(100, 12, 15, 100));
            Label label = new Label("Modify Product");
            label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            label.setPadding(new Insets(0, 50, 0, 0));
            
            top.getChildren().addAll(label);

            return top;
        }
        
        // Labels on Left of Modify Product Screen
        public VBox modifyProductLabels() {
            VBox left = new VBox();
            left.setSpacing(30);
            left.setPadding(new Insets(45, 5, 5, 75));
            
            left.getChildren().addAll(idLabel, nameLabel, invLabel, priceLabel,
                    maxLabel);
            
            return left;
        }
        
        // Right Text Fields on Modify Product Screen
        public VBox modifyProductTextBoxes(Product product) {
            VBox right = new VBox();
            right.setSpacing(25);
            right.setPadding(new Insets(40, 125, 5, 5));
            
            idBox.setFont(ITALICS);
            idBox.setText(String.valueOf(product.getProductID()));
            idBox.setDisable(true);
            idBox.setMaxWidth(125);
            
            nameBox.setFont(ITALICS);
            nameBox.setMaxWidth(100);
            nameBox.setText(product.getName());
            
            invBox.setFont(ITALICS);
            invBox.setMaxWidth(100);
            invBox.setText(String.valueOf(product.getInstock()));
            
            priceBox.setFont(ITALICS);
            priceBox.setMaxWidth(100);
            priceBox.setText(String.valueOf(product.getPrice()));

            HBox maxMin = new HBox();
            
            maxBox.setFont(ITALICS);
            maxBox.setMaxWidth(50);
            maxBox.setText(String.valueOf(product.getMax()));
            
            minLabel.setPadding(new Insets(0, 15, 0, 15));
            minBox.setFont(ITALICS);
            minBox.setMaxWidth(50);
            minBox.setText(String.valueOf(product.getMin()));
            
            maxMin.getChildren().addAll(maxBox, minLabel, minBox);

            right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                    maxMin);
            
            return right;
        }
        
        // Buttons for Modify Product Screen
        public VBox rightLayout(Product product) {
            VBox rightLayout = new VBox();
            
            // Top Search Button
            HBox searchHBox = new HBox();
            searchHBox.setSpacing(15);
            searchHBox.setPadding(new Insets(75, 150, 0, 100));
            Button searchPartsTop = new Button("Search");
            
            // Middle Add Button
            HBox addBtnHBox = new HBox();
            addBtnHBox.setPadding(new Insets(15, 5, 5, 335));
            Button addBtn = new Button("Add");
                addBtn.setOnAction((ActionEvent e) -> {
                    if (!rightBottomTable.getItems().contains(rightTopTable.getSelectionModel().getSelectedItem())) {
                    newProduct.addPart(rightTopTable.getSelectionModel().getSelectedItem());
                    System.out.println("Added!");
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
                Part part = rightBottomTable.getSelectionModel().getSelectedItem(); // Using polymorphism
                newProduct.removePart(part.getPartID());
            });
            delBtn.setMinWidth(75);
            delBtnHBox.getChildren().addAll(delBtn);
            
            // Parts Search Field
            TextField searchField = new TextField();
            searchField.setPromptText("Part ID");
            searchField.setMaxWidth(200);
            
            
            
            // Parts Search Button Action - Finds the part in Inventory by PartID then adds it to 
            // a new ObservableList to populate the tableview
            searchPartsTop.setOnAction((ActionEvent e) -> {
                Part part = Inventory.lookupPart(Integer.parseInt(searchField.getText())); // Using polymorphism
                ObservableList<Part> searchPart = FXCollections.observableArrayList();
                searchPart.add(part);
                rightTopTable.setItems(searchPart);
            });
            
            searchHBox.getChildren().addAll(searchPartsTop, searchField);
            
            rightLayout.getChildren().addAll(searchHBox, rightTopTable(), addBtnHBox
                                                , rightBottomTable(product), delBtnHBox);
            return rightLayout;
        }
        
        public VBox rightTopTable() {
            
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
            
            rightTopTable.setItems(Inventory.getALLPARTS());
            rightTopTable.getColumns().addAll(partID, partName, invLevelParts, pricePart);
            
            final VBox topTable = new VBox();
            topTable.setMaxHeight(150);
            topTable.setPadding(new Insets(10, 150, 0, 0));
            topTable.getChildren().addAll(rightTopTable);
            return topTable;
        }
        
        public VBox rightBottomTable(Product product) {
            
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
            
            newProduct = product;
            rightBottomTable.setItems(newProduct.getParts());
            rightBottomTable.getColumns().addAll(partID, partName, invLevelParts, pricePart);
            
            final VBox botTable = new VBox();
            botTable.setMaxHeight(150);
            botTable.setPadding(new Insets(20, 150, 0, 0));
            botTable.getChildren().addAll(rightBottomTable);
            return botTable;
        }
}
