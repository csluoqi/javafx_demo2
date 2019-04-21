package sample4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author lq
 * 创建时间 2019/4/21 9:04
 **/
public class MultiStageMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("fistStage");
        System.out.println(getClass().getClassLoader());
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/sample4/firstStage.fxml"));
        Parent root = fxmlLoader.load();

        MultiStageController controller = fxmlLoader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
