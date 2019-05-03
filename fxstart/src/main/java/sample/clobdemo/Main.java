package sample.clobdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/clobdemo/sample.fxml"));
        primaryStage.setTitle("Hello World");
        FileChooser fileChooser = new FileChooser();
        Button fileChooseBtn= (Button)root.lookup("#chooseFile");
        fileChooseBtn.setOnAction(event -> {
            Msg.file = fileChooser.showOpenDialog(primaryStage);
            if(Msg.file!=null){
                TextField filePath = (TextField) root.lookup("#filePath");
                filePath.setText(Msg.file.getAbsolutePath());
            }
        });
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
