package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

/**
 * @author lq
 * 创建时间 2019/4/12 0:46
 **/
public class FXMLExample2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // 加载图片
//        FileInputStream input = new FileInputStream("C:\\Users\\lq\\Pictures\\jq\\微信图片_20190323105823.jpg");
//        Image image = new Image(input);
//        ImageView imageView = new ImageView(image);
//        Scene scene = new Scene(new VBox(imageView));

        // add label
//        Label label = new Label("my label");
//        Scene scene = new Scene(label,200,300);

        //image in label

//        FileInputStream input = new FileInputStream("C:\\Users\\lq\\Pictures\\JYYH\\按钮图\\tomcat.png");
//        Image image = new Image(input);
//
//        ImageView imageView = new ImageView(image);
//        Label label = new Label("my balel",imageView);
//
//        Scene scene = new Scene(label);

//        Button button = new Button("my button,asdfsadfasdfasdfadfasdf");
//        button.setWrapText(true);
//        Scene scene = new Scene(button,100,200);



//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lq\\Pictures\\JYYH\\按钮图\\tomcat.png");
//        Image image = new Image(fileInputStream);
//        ImageView imageView = new ImageView(image);
//        Button button = new Button("my button",imageView);


        Label label = new Label("my label");


        //mnemonic 快捷键
        Button button = new Button("_my button");
        button.setMnemonicParsing(true);
        button.setStyle("-fx-background-color: #c3c3c3; ");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
        button.setOnAction(event->{
        label.setText(""+System.currentTimeMillis()%100);
        });
        HBox hBox = new HBox(label,button);
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
