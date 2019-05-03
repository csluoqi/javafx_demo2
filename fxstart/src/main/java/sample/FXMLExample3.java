package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Button bt1 = new Button("button1");
        Button bt2 = new Button("button2");
        Button bt3 = new Button("button3");
        Button bt4 = new Button("button4");

        bt1.setStyle("-fx-border-color: #111fff;-fx-border-width: 5px");
        bt2.setStyle("-fx-background-color: #f2f222");
        bt3.setStyle("-fx-font-size: 2em");
        bt4.setStyle("-fx-text-fill: #000fff");


        HBox hBox = new HBox(bt1,bt2,bt3,bt4);
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
