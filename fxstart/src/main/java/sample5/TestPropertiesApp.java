package sample5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author lq
 * 创建时间 2019/4/23 16:32
 **/
public class TestPropertiesApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("test");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sample5/testProperties.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
