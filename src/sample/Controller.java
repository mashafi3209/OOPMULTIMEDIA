package sample;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {

  Statement statement;
  @FXML
  private TextField ProductNameField;

  @FXML
  private TextField ManufactureField;

  @FXML
  private ComboBox<String> ItemTypeCombobox;

  @FXML
  private Button btnaddproduct;

  @FXML
  private ComboBox<String> ChooseQuantity;

  @FXML
  private Button RecordProduction;

  @FXML
  private TextField serialRec;
  @FXML
  private ListView<String> recordsList;
  @FXML
  void recordProductionAction(ActionEvent event) {
    String tempStringa = recordsList.getSelectionModel().getSelectedItem();

    String[] tempString = tempStringa.split("/",2);
    String idOfTheSelection = tempString[1];
    int idSelected = Integer.parseInt(idOfTheSelection);

    String serial = serialRec.getText();
    String quantityTemp = ChooseQuantity.getValue();
    int quantity = Integer.parseInt(quantityTemp);
    Date date= new Date(System.currentTimeMillis());

    long time = date.getTime();


    Timestamp timeStamp = new Timestamp(time);



    try{
      DatabaseManager db = new DatabaseManager();
      db.RecordProduction(quantity,idSelected,serial, timeStamp);


      } catch (SQLException ex) {
      ex.printStackTrace();
    }


  }







  @FXML
  public void initialize() {

    for (int i = 0; i < 10; i++) {
      ChooseQuantity.getItems().add(String.valueOf(i+1));
    }
    for (int i = 0; i < ItemType.values().length; i++) {
      ItemTypeCombobox.getItems().add(ItemType.values()[i].name());


    }

    /*for (ItemType i: ItemType.values()){
      ItemTypeCombobox.getItems().add(i.name());


    }*/
    try{



      DatabaseManager db = new DatabaseManager();
      List<String > listOfitem = db.listViewRecord();
      for(int i = 0; i< listOfitem.size();i++){
        recordsList.getItems().add(listOfitem.get(i));

      }


    } catch (SQLException e) {
      e.printStackTrace();
    }

    ItemTypeCombobox.getSelectionModel().selectFirst();

    ChooseQuantity.setEditable(true);

  }


  @FXML
  void onaddproduct(ActionEvent event) throws SQLException {
    try {
      String productName = ProductNameField.getText();
      String manufacturerName = ManufactureField.getText();
      String itemType = ItemTypeCombobox.getValue();


      DatabaseManager db = new DatabaseManager();
      db.TableProduct(itemType, productName, manufacturerName);

    } catch (SQLException var4) {
      var4.printStackTrace();
    }



  }
  public static List<ProductionRecord> records = new ArrayList<>();


}
