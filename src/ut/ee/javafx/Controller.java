package ut.ee.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ut.ee.pank.var4.HoiusKonto;
import ut.ee.pank.var4.Konto;
import ut.ee.pank.var4.TavalineKonto;

public class Controller {

  @FXML
  private TextField nimiField;
  @FXML
  private TextField PINField;
  @FXML
  private TextField saldoField;

  @FXML
  private CheckBox isHoiusKontoCheckBox;

  @FXML
  private TextField pikkusPaevadesField;

  @FXML
  private ListView<Konto> kontoListView;

  public Controller() {
    System.out.println("1");
  }

  @FXML
  private void enableHoiusKonto() {
    pikkusPaevadesField.setDisable(!pikkusPaevadesField.isDisabled());
  }

  @FXML
  private void lisaKonto() {
    String nimi = nimiField.getText();
    int PIN = Integer.parseInt(PINField.getText());
    double amount = Double.parseDouble(saldoField.getText());

    Konto konto;

    if (isHoiusKontoCheckBox.isSelected()) {
      int pikkus = Integer.parseInt(pikkusPaevadesField.getText());
      konto = new HoiusKonto(nimi, PIN, amount, pikkus);
    }
    else {
      konto = new TavalineKonto(nimi, PIN, amount);
    }

    kontoListView.getItems().add(konto);
    resetFields();
  }

  private void resetFields() {
    nimiField.clear();
    PINField.clear();
    saldoField.clear();
    pikkusPaevadesField.clear();
  }

  @FXML
  private void initialize() {
    System.out.println("2");
  }

}
