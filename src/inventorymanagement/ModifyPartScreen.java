
package inventorymanagement;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class ModifyPartScreen {
    
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    final private Label compLabel = new Label("Comp Nm");
    final private Label idLabel = new Label("ID");
    final private Label nameLabel = new Label("Name");
    final private Label invLabel = new Label("Inv");
    final private Label priceLabel = new Label("Price/Cost");
    final private Label maxLabel = new Label("Max");
    final private Label minLabel = new Label("Min");
    
    public TextField idBox = new TextField();
    public TextField nameBox = new TextField();
    public TextField invBox = new TextField();
    public TextField priceBox = new TextField();
    public TextField maxBox = new TextField();
    public TextField minBox = new TextField();
    public TextField compMachBox = new TextField();
    
    private final RadioButton inHouse = new RadioButton();
    private final RadioButton outsourced = new RadioButton();
       
    
    public void modifyPart(Part part) {
        Stage stage = new Stage();
        BorderPane bp = new BorderPane();
        
        // Populating Textfields with part grabbed from main screen
        if (part.getClass().equals(InHousePart.class)) {
            InHousePart modPart = (InHousePart)part; // Downcasting part to proper subclass
            idBox.setText(String.valueOf(modPart.getPartID()));
            idBox.setDisable(true); // Making sure ID can't be changed
            nameBox.setText(modPart.getName());
            invBox.setText(String.valueOf(modPart.getInstock()));
            priceBox.setText(String.valueOf(modPart.getPrice()));
            maxBox.setText(String.valueOf(modPart.getMax()));
            minBox.setText(String.valueOf(modPart.getMin()));
            compMachBox.setText(String.valueOf(modPart.getMachineID()));
        }
        else {
            OutsourcedPart modPart = (OutsourcedPart)part; // Downcasting part to proper subclass
            idBox.setText(String.valueOf(modPart.getPartID()));
            idBox.setDisable(true); // Making sure ID can't be changed
            nameBox.setText(modPart.getName());
            invBox.setText(String.valueOf(modPart.getInstock()));
            priceBox.setText(String.valueOf(modPart.getPrice()));
            maxBox.setText(String.valueOf(modPart.getMax()));
            minBox.setText(String.valueOf(modPart.getMin()));
            compMachBox.setText(modPart.getCompanyName());
        }
        
        // Buttons on Bottom
        HBox btns = new HBox();
        btns.setAlignment(Pos.CENTER_RIGHT);
        btns.setSpacing(20);
        btns.setPadding(new Insets(0, 100, 20, 0));
        
        // Save button calls update Part from the Part Class
        Button saveBtn = new Button("Save");
        saveBtn.setOnAction((ActionEvent e) -> {
            if (inHouse.isSelected() == true) {
                InHousePart newPart = new InHousePart();
                newPart.setPartID(part.getPartID());
                newPart.setName(nameBox.getText());
                newPart.setInstock(Integer.parseInt(invBox.getText()));
                newPart.setPrice(Double.parseDouble(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setMachineID(Integer.parseInt(compMachBox.getText()));
                Inventory.updatePart(part.getPartID(), newPart);
                stage.close();
            }
            else {
                OutsourcedPart newPart = new OutsourcedPart();
                newPart.setPartID(part.getPartID());
                newPart.setName(nameBox.getText());
                newPart.setInstock(Integer.parseInt(invBox.getText()));
                newPart.setPrice(Double.parseDouble(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setCompanyName(compMachBox.getText());
                Inventory.updatePart(part.getPartID(), newPart);
                stage.close();
            }
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            stage.close();
        });
        
        btns.getChildren().addAll(saveBtn, cancelBtn);
        
        bp.setTop(modifyPartTop(part));
        bp.setLeft(modifyPartLeft());
        bp.setRight(modifyPartRight());
        bp.setBottom(btns);
        
        Scene scene = new Scene(bp, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
    
        // Top Items on Modify Part Screen
        public HBox modifyPartTop(Part part) {
            ToggleGroup radio = new ToggleGroup();
            HBox top = new HBox();
            top.setSpacing(20);
            top.setPadding(new Insets(15, 12, 15, 12));
            Label label = new Label("Modify Part");
            label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            label.setPadding(new Insets(0, 50, 0, 0));
            
            // In-House Radio Button
            inHouse.setToggleGroup(radio);
            // inHouse.setSelected(true);
            Label inHouseLabel = new Label("In-House");
            
            // Outsourced Radio Button
            outsourced.setToggleGroup(radio);
            Label outsourcedLabel = new Label("Outsourced");
            
            // Selects the button that the part being modified is
            if (part.getClass().equals(InHousePart.class)) {
                inHouse.setSelected(true);
            }
            else {
                outsourced.setSelected(true);
            }
            
            // Changes the Text Fields depending on which RadioButton is selected
            radio.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
                if (inHouse.isSelected() == true)
                    changeLabel("Machine ID");
                else
                    changeLabel("Company Name");
            });
            
            
            top.getChildren().addAll(label, inHouse, inHouseLabel, outsourced, outsourcedLabel);

            return top;
        }
        
        // Labels on Left of Modify Part Screen
        public VBox modifyPartLeft() {
            VBox left = new VBox();
            left.setSpacing(30);
            left.setPadding(new Insets(15, 5, 5, 75));
            
            left.getChildren().addAll(idLabel, nameLabel, invLabel, priceLabel,
                    maxLabel, compLabel);
            
            return left;
        }
        
        // Right Text Fields on Modify Part Screen
        public VBox modifyPartRight() {
            VBox right = new VBox();
            right.setSpacing(25);
            right.setPadding(new Insets(10, 125, 5, 5));
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
            
            minLabel.setPadding(new Insets(5, 15, 0, 15));
            
            minBox.setFont(ITALICS);
            minBox.setMaxWidth(50);
            maxMin.getChildren().addAll(maxBox, minLabel, minBox);
            
            compMachBox.setFont(ITALICS);
            compMachBox.setMaxWidth(100);

            right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                    maxMin, compMachBox);
            
            return right;
        }
        
        public void changeLabel(String label) {
            compLabel.setText(label);
        }
    
}
