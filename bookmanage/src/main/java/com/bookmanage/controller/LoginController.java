package com.bookmanage.controller;

import com.bookmanage.application.ConfigTool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

/**
 * @author lq
 * 创建时间 2019/5/3 16:08
 **/
@Controller
public class LoginController {
    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;
    @FXML
    public Button loginbtn;

    public void login_click(ActionEvent actionEvent) {
        closeWin();
        ConfigTool.showHomeStage();
    }


    //关闭当前窗体
    public void closeWin(){
        System.err.println("关闭当前窗体");
        Stage stage=(Stage)loginbtn.getScene().getWindow();
        stage.close();
    }
}
