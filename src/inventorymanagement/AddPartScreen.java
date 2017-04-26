
package inventorymanagement;

import java.util.Optional;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
public class AddPartScreen {
    
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    private final Label compMachLabel = new Label("Mach ID");
    private final Label idLabel = new Label("ID");
    private final Label nameLabel = new Label("Name");
    private final Label invLabel = new Label("Inv");
    private final Label priceLabel = new Label("Price/Cost");
    private final Label maxLabel = new Label("Max");
    private final Label minLabel = new Label("Min");
    
    private final TextField idBox = new TextField("Auto Gen - Disabled");
    private final TextField nameBox = new TextField();
    private final TextField invBox = new TextField();
    private final TextField priceBox = new TextField();
    private final TextField maxBox = new TextField();
    private final TextField minBox = new TextField();
    private final TextField compMachBox = new TextField();
    
    private final RadioButton inHouse = new RadioButton();
    private final RadioButton outsourced = new RadioButton();
    
    
    public void addPart() {
        Stage stage = new Stage();
        BorderPane bp = new BorderPane();

        // Buttons on Bottom
        HBox btns = new HBox();
        btns.setAlignment(Pos.CENTER_RIGHT);
        btns.setSpacing(20);
        btns.setPadding(new Insets(0, 100, 20, 0));
        
        // Save Part
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction((ActionEvent e) -> {
            if (inHouse.isSelected() == true) {
                InHousePart newPart = new InHousePart();
                newPart.setPartID();
                newPart.setName(nameBox.getText());
                newPart.setInstock(Integer.parseInt(invBox.getText()));
                newPart.setPrice(Double.parseDouble(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setMachineID(Integer.parseInt(compMachBox.getText()));
                Inventory.addPart(newPart);
                stage.close();
            }
            else {
                OutsourcedPart newPart = new OutsourcedPart();
                newPart.setPartID();
                newPart.setName(nameBox.getText());
                newPart.setInstock(Integer.parseInt(invBox.getText()));
                newPart.setPrice(Double.parseDouble(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setCompanyName(compMachBox.getText());
                Inventory.addPart(newPart);
                stage.close();
            }
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            Alert confirmCancel = new Alert(AlertType.CONFIRMATION);
            confirmCancel.setTitle("Confirm Cancel");
            confirmCancel.setHeaderText("");
            confirmCancel.setContentText("Are you sure you want to exit without saving?");

            Optional<ButtonType> option = confirmCancel.showAndWait();
            if (option.get() == ButtonType.OK){
               stage.close();
            } else {
               bp.requestFocus();
            }
        });
        
        btns.getChildren().addAll(saveBtn, cancelBtn);
        
        bp.setTop(addPartTop());
        bp.setLeft(addPartLeft());
        bp.setRight(addPartRight());
        bp.setBottom(btns);
        
        Scene scene = new Scene(bp, 400, 400);
        stage.setScene(scene);
        stage.show();
        bp.requestFocus();
    }
    
        // Top Items on Add Part Screen
        public HBox addPartTop() {
            ToggleGroup radio = new ToggleGroup();
            HBox top = new HBox();
            top.setSpacing(20);
            top.setPadding(new Insets(15, 12, 15, 12));
            Label label = new Label("Add Part");
            label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            label.setPadding(new Insets(0, 50, 0, 0));
            
            // In-House Radio Button
            inHouse.setToggleGroup(radio);
            inHouse.setSelected(true);
            Label inHouseLabel = new Label("In-House");
            
            // Outsourced Radio Button
            outsourced.setToggleGroup(radio);
            Label outsourcedLabel = new Label("Outsourced");
            
            // Changes the Options depending on which RadioButton is selected
            radio.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
                if (inHouse.isSelected() == true) {
                    changeLabel("Machine ID", "Mach ID");
                }
                else {
                    changeLabel("Company Name", "Comp Nm");
                }
            });
            
            
            top.getChildren().addAll(label, inHouse, inHouseLabel, outsourced, outsourcedLabel);

            return top;
        }
        
        // Labels on Left of Add Part Screen
        public VBox addPartLeft() {
            VBox left = new VBox();
            left.setSpacing(30);
            left.setPadding(new Insets(15, 5, 5, 75));
            
            left.getChildren().addAll(idLabel, nameLabel, invLabel, priceLabel,
                    maxLabel, compMachLabel);
            
            return left;
        }
        
        // Right Text Fields on Add Part Screen
        public VBox addPartRight() {
            VBox right = new VBox();
            right.setSpacing(25);
            right.setPadding(new Insets(10, 125, 5, 5));
            idBox.setFont(ITALICS);
            idBox.setDisable(true);
            idBox.setMaxWidth(125);
            
            nameBox.setPromptText("Part Name");
            nameBox.setFont(ITALICS);
            nameBox.setMaxWidth(100);
            
            invBox.setPromptText("Inv");
            invBox.setFont(ITALICS);
            invBox.setMaxWidth(100);
                        
            priceBox.setPromptText("Price/Cost");
            priceBox.setFont(ITALICS);
            priceBox.setMaxWidth(100);

            HBox maxMin = new HBox();
                        
            maxBox.setPromptText("Max");
            maxBox.setFont(ITALICS);
            maxBox.setMaxWidth(50);
            
            minLabel.setPadding(new Insets(0, 15, 0, 15));
                        
            minBox.setPromptText("Min");
            minBox.setFont(ITALICS);
            minBox.setMaxWidth(50);
            
            maxMin.getChildren().addAll(maxBox, minLabel, minBox);
            
            compMachBox.setPromptText("Mach ID");
            compMachBox.setFont(ITALICS);
            compMachBox.setMaxWidth(100);

            right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                    maxMin, compMachBox);
            
            return right;
        }
        
        public void changeLabel(String label, String field) {
            compMachLabel.setText(label);
            compMachBox.setPromptText(field);
        }
}
    

    
