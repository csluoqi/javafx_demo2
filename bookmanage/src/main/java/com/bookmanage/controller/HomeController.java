package com.bookmanage.controller;

import com.bookmanage.constants.SpringFxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

/**
 * @author lq
 * 创建时间 2019/5/4 0:01
 **/
@Controller
public class HomeController {
    @FXML
    public AnchorPane mainPane;
    private static SpringFxmlLoader loader = new SpringFxmlLoader();

    public void typeManageClick(ActionEvent actionEvent) {
        mainPane.getChildren().setAll(loader.load("/fxml/bookTypeManage.fxml"));
    }


}
