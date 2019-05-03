package sample3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author lq
 * 创建时间 2019/4/16 12:37
 **/
public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        TitledPane firstTitledpane = new TitledPane();
        firstTitledpane.setText("Java");

        VBox content1 = new VBox();

        content1.getChildren().add(new Label("java Swing Tutorial"));
        content1.getChildren().add(new Label("javaFx  Tutorial"));
        content1.getChildren().add(new Label("java IO Tutorial"));

        firstTitledpane.setContent(content1);

        TitledPane secondTitlePane = new TitledPane();
        secondTitlePane.setText("C#");

        VBox vbox2 = new VBox();
        vbox2.getChildren().add(new Label("C# Tutorial for beginners"));
        vbox2.getChildren().add(new Label("C# Enums Tutorial"));

        secondTitlePane.setContent(vbox2);
        Accordion root = new Accordion();
        root.getPanes().addAll(firstTitledpane,secondTitlePane);



        //scrollPane.setPannable(true);
        Scene scene = new Scene(root, 550, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void start2(Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        Button button = new Button("my Button");
        button.setPrefSize(400,300);

        Button button1 = new Button("second Button");
        button1.setPrefSize(200,200);

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(button,button1);
        scrollPane.setContent(flowPane);

        //scrollPane.setPannable(true);
        Scene scene = new Scene(scrollPane, 550, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void start1(Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        Button button = new Button("my Button");
        button.setPrefSize(400,300);

        scrollPane.setContent(button);

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        primaryStage.setTitle("ScrollPane Demo 1");


        Scene scene = new Scene(scrollPane, 550, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
