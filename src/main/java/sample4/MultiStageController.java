package sample4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/**
 * @author lq
 * 创建时间 2019/4/21 9:04
 **/
public class MultiStageController {


    private Stage primaryStage;
    private Stage secondStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public Button toscondStagebtn;
    @FXML
    public Button closeWin;

    @FXML
    public Button gotoLogin;

    public void toScondStage(ActionEvent actionEvent) throws IOException {
        secondStage = new Stage();
        secondStage.setTitle("second window");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sample4/secondStage.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene  = new Scene(root);
        secondStage.setScene(scene);
        secondStage.show();
        this.primaryStage.hide();
    }

    public void closeWin(ActionEvent actionEvent) {
        Stage window = (Stage) closeWin.getScene().getWindow();
        window.close();
    }

    public void gotoLogin(ActionEvent actionEvent) throws IOException {

        System.out.println(secondStage);
        primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/sample4/firstStage.fxml"));
        Parent root = fxmlLoader.load();

        MultiStageController controller = fxmlLoader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        Stage window = (Stage) gotoLogin.getScene().getWindow();
        window.close();

    }
}
