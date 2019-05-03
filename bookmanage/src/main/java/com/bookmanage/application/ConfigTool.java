package com.bookmanage.application;

import com.bookmanage.constants.SpringFxmlLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author lq
 * 创建时间 2019/5/4 0:10
 **/
public class ConfigTool {
    private static SpringFxmlLoader loader= new SpringFxmlLoader();

    public static void showHomeStage() {
        Stage stage = new Stage();
        stage.setTitle("");
        Pane pane = new Pane();
        pane.getChildren().setAll(loader.load("/fxml/home.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        //DragUtil.addDragListener(stage, pane); //拖拽监听
        stage.show();
    }

}
