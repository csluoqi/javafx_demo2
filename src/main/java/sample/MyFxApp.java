package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class MyFxApp  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("my first javaFx app");
        //primaryStage.initStyle(StageStyle.UTILITY);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

//        stage.initStyle(StageStyle.DECORATED);

//stage.initStyle(StageStyle.UNDECORATED);
//stage.initStyle(StageStyle.TRANSPARENT);
stage.initStyle(StageStyle.UNIFIED);
//stage.initStyle(StageStyle.UTILITY);

        Label label = new Label("hello world ,JavaFx!!");
        byte[] bytes = Files.readAllBytes(Paths.get("D:\\___WORK\\javaGUI\\workspace\\javafx_demo1\\src\\sample\\MyFxApp.java"));
        String code = new String(bytes);
        TextArea codeText = new TextArea(code);
        Scene scene = new Scene(codeText,400,200);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        primaryStage.show();
        stage.show();
        System.out.println("stage exit");
//        primaryStage.showAndWait();
        //Caused by: java.lang.IllegalStateException: Cannot call this method on primary stage
        System.out.println("stage ...");
    }
}
