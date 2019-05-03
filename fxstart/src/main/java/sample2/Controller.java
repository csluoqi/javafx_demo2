package sample2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;

    public void showDateTIme(ActionEvent actionEvent) {
        System.out.println("Button click");
        myTextField.setText(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
    }
}
