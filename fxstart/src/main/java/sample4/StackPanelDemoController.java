package sample4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author lq
 * 创建时间 2019/4/21 11:18
 **/
public class StackPanelDemoController {
    @FXML
    public Button menubtn;
    @FXML
    public Button editbtn;
    @FXML
    public Button svaebtn;
    @FXML
    public VBox savePane;
    @FXML
    public VBox menuPane;
    @FXML
    public VBox editPane;

    public void menubtn_click(ActionEvent actionEvent) {
        menuPane.setVisible(true);
        savePane.setVisible(false);
        editPane.setVisible(false);

    }

    public void editbtn_click(ActionEvent actionEvent) {
        editPane.setVisible(true);
        savePane.setVisible(false);
        menuPane.setVisible(false);
    }

    public void svaebtn_click(ActionEvent actionEvent) {
        savePane.setVisible(true);
        menuPane.setVisible(false);
        editPane.setVisible(false);
    }
}
