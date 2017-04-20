
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
public class AddPartScreen {
    
    public static final Font ITALICS = Font.font("Arial", FontPosture.ITALIC,
            Font.getDefault().getSize());
    
    final private Label compMachLabel = new Label("Comp Nm");
    final private Label idLabel = new Label("ID");
    final private Label nameLabel = new Label("Name");
    final private Label invLabel = new Label("Inv");
    final private Label priceLabel = new Label("Price/Cost");
    final private Label maxLabel = new Label("Max");
    
    final private TextField idBox = new TextField("Auto Gen - Disabled");
    final private TextField nameBox = new TextField("Part Name");
    final private TextField invBox = new TextField("Inv");
    final private TextField priceBox = new TextField("Price/Cost");
    final private TextField maxBox = new TextField("Max");
    final private TextField minBox = new TextField("Min");
    final private Label minLabel = new Label("Min");
    final private TextField compMachBox = new TextField("Comp Nm");
    
    final private RadioButton inHouse = new RadioButton();
    final private RadioButton outsourced = new RadioButton();
    
    
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
                newPart.setPrice(Integer.parseInt(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setMachineID(Integer.parseInt(compMachBox.getText()));
            }
            else {
                OutsourcedPart newPart = new OutsourcedPart();
                newPart.setPartID();
                newPart.setName(nameBox.getText());
                newPart.setInstock(Integer.parseInt(invBox.getText()));
                newPart.setPrice(Integer.parseInt(invBox.getText()));
                newPart.setMax(Integer.parseInt(invBox.getText()));
                newPart.setMin(Integer.parseInt(invBox.getText()));
                newPart.setCompanyName(compMachBox.getText());
            }
        });
        
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction((ActionEvent e) -> {
            stage.close();
        });
        
        btns.getChildren().addAll(saveBtn, cancelBtn);
        
        bp.setTop(addPartTop());
        bp.setLeft(addPartLeft());
        bp.setRight(addPartRight());
        bp.setBottom(btns);
        
        Scene scene = new Scene(bp, 400, 400);
        stage.setScene(scene);
        stage.show();
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
                    changeLabel("Company Name", "Comp Nm");
                }
                else {
                    changeLabel("Machine ID", "Mach ID");
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
            
            compMachBox.setFont(ITALICS);
            compMachBox.setMaxWidth(100);

            right.getChildren().addAll(idBox, nameBox, invBox, priceBox, 
                    maxMin, compMachBox);
            
            return right;
        }
        
        public void changeLabel(String label, String field) {
            compMachLabel.setText(label);
            compMachBox.setText(field);
        }
}
    

    
