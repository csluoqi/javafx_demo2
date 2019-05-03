package com.bookmanage.controller;

import com.bookmanage.model.Type;
import com.bookmanage.service.type.TypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author lq
 * 创建时间 2019/5/3 17:48
 **/
@Controller
public class BookTypeManageController implements Initializable {

    @Autowired
    private TypeService typeService;
    @FXML
    public TableView typeManageTable;

    ObservableList observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Type> typeList = typeService.selectType("中", 1, 20);
        System.out.println(typeList.size());
        //展示
        observableList.addAll(typeList);
        typeManageTable.setItems(observableList);

    }
}
