package sample4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author lq
 * 创建时间 2019/4/21 11:17
 **/
public class StackPanelDemoMain extends Application {

    /**
     *经过美化的版本
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("stackPane demo");
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("/fxml/sample4/stackPanelDemo2.fxml"));
        Parent root = fxmLoader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    /*
    未经过美化的效果
     */
    public void start1(Stage primaryStage) throws Exception {
        primaryStage.setTitle("stackPane demo");
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("/fxml/sample4/stackPanelDemo.fxml"));
        Parent root = fxmLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
