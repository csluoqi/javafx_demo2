package sample6.JsonDemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author lq
 * 创建时间 2019/4/26 12:44
 **/
public class JsonMain  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();
        webView.setPrefHeight(800);
        webView.setPrefWidth(1200);
        //json.cn 嵌入
        webView.getEngine().load("file:///D:\\test\\jstest\\jsondemo2.html");


        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 1200, 800);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
