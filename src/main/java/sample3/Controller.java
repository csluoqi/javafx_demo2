package sample3;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {


    @FXML
    public Button mybutton;
    @FXML
    public StackPane stackPanel;
    @FXML
    public Button btn1;
    @FXML
    public CheckBox ckbox1;
    @FXML
    public Label lab1;

    public void changetop(ActionEvent actionEvent) {

        ObservableList<Node> children = stackPanel.getChildren();
        if(children.size()>1){
            Node topNode = children.get(children.size()-1);

            Node newtopNode = children.get(children.size()-2);

            topNode.toBack();
            newtopNode.setVisible(true);
        }
    }
}
