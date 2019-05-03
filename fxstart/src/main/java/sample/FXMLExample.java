package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///D:/___WORK/javaGUI/workspace/javafx_demo1/src/sample/demo1.fxml"));

        VBox vBox = loader.<VBox>load();
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
